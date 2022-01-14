package com.qxf.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.qxf.ftp.UploadUtil;
import com.qxf.hiswww.domain.TStudentCourseTeacher;
import com.qxf.pojo.*;
import com.qxf.service.*;
import com.qxf.utils.EnumCode;
import com.qxf.utils.ExcelUtil;
import com.qxf.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.security.provider.MD5;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: WangWeiWen
 * @Date: 2021/11/15
 * @Description: com.qxf.controller
 */
@RestController
@RequestMapping(value = "user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    Map<String, String> uploadImg;

    @Autowired
    private RoleService roleService;

    /**
     * 上传用户头像
     */
    @ResponseBody
    @RequestMapping(value = "/uploadHander", method = RequestMethod.POST)
    public String uploadLogo(HttpServletRequest request) {
        uploadImg = new HashMap<String, String>();
        uploadImg = UploadUtil.uploadImage(request, "vue_shiro_photo/userImg");
        return uploadImg.get("pic");
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                /*
                 * 这段代码执行完毕之后，图片上传到了工程的跟路径； 大家自己扩散下思维，如果我们想把图片上传到
                 * d:/files大家是否能实现呢？ 等等;
                 * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如： 1、文件路径； 2、文件名；
                 * 3、文件格式; 4、文件大小的限制;
                 */
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                System.out.println(file.getName());
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }

            return "上传成功";

        } else {
            return "上传失败，因为文件是空的.";
        }
    }

    /**
     * @desc: 查询用户
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object findUserByPage(Integer startPage,Integer pageSize) {

        Page<User> page = new Page<User>(startPage,pageSize);
        User user = new User();
        List<User> list = userService.findUserByPage(page,user);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list, page.getTotal());
    }

    /**
     * @desc: 新增用户
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addUser(@Valid User userVo, BindingResult bindingResult) {
        return userService.addUser(userVo);
    }

    /**
     * @desc: 批量删除用户
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object delUsers(User user) {
        String[] ids = user.getIds();
        if (null == ids || ids.length == 0) {
            return ResultUtil.result(EnumCode.BAD_REQUEST.getValue(), EnumCode.BAD_REQUEST.getText());
        }
        return userService.delUsers(ids);
    }

    /**
     * 修改用户状态
     */
    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public Object editUserStatus(User dto) {
        if (StringUtils.isEmpty(dto.getId()) || null == dto.getEnable()) {
            return ResultUtil.result(EnumCode.BAD_REQUEST.getValue(), EnumCode.BAD_REQUEST.getText());
        }
        return userService.editUserStatus(dto);
    }

    /**
     * 用户修改用户个人信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object editUserInfo(User vo) {
        return userService.editUserInfo(vo);
    }


    /**
     * 导出报表，这里get和post请求复用了该方法，仅仅是为了测试
     *
     * @return
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(@RequestBody(required = false) User user,String username,HttpServletResponse response) throws Exception {
        if (user ==null && !StringUtils.isEmpty(username)){
            //GET 请求的参数
            user = new User();
            user.setUsername(username);
        }
        //获取数据
        List<User> list = userService.findAllUser(user);

        //excel标题
        String[] title = {"姓名", "邮箱", "创建时间", "最近登录时间","角色","是否可用"};

        //excel文件名
        String fileName = System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "用户信息";

        //没有数据就传入null吧，Excel工具类有对null判断
        String [][] content = null;

        if (list != null && list.size() > 0){
            content = new String[list.size()][title.length];
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            for (int i = 0; i < list.size(); i++) {
                content[i] = new String[title.length];
                User obj = list.get(i);
                content[i][0] = obj.getUsername();
                content[i][1] = obj.getEmail();
                content[i][2] = obj.getCreateTime() == null ? "" : sdf.format(obj.getCreateTime());
                content[i][3] = obj.getLastLoginTime() == null ? "": sdf.format(obj.getLastLoginTime());
                content[i][4] = obj.getRoleName();
                content[i][5] = obj.getEnable()==1 ? "是" : "否";
            }
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content);

        //响应到客户端
        try {
//            fileName = new String(fileName.getBytes(), "UTF-8");
//            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 批量导入用户
     *
     */
    @RequestMapping(value = "/import")
    @ResponseBody
    public Object ExcelImport(MultipartFile[] multipartFiles) throws Exception {
        if (multipartFiles == null || multipartFiles.length < 1){
            return ResultUtil.result(EnumCode.INTERNAL_SERVER_ERROR.getValue(),"空数据，导入失败");
        }
        for (MultipartFile file : multipartFiles){
            List<String[]> list = ExcelUtil.readExcel(file);
            if (list.isEmpty()){
                return ResultUtil.result(EnumCode.INTERNAL_SERVER_ERROR.getValue(),"空数据，导入失败");
            }

            //查询数据库的所有角色并且赋值
            List<Role> allRoles = roleService.findAllRoles();

            for (int i=0;i<list.size();i++){
                String[] values = list.get(i);
                //这里只导入了3列数据：姓名、邮箱和是否可用（0、1），其他列可自行导入，现转换格式再写入数据库，比如：
                //导入角色的时候，根据角色名称查找角色id，如果角色id不存在，可以默认为学生之类的处理
                User user = new User();
                user.setUsername(values[0]);
                user.setEmail(values[1]);
//                user.setEnable(values[2] == null ? 1 : Integer.valueOf(values[2]));
                //判断是否激活
                if (values[5].equals("是") ){
                    user.setEnable(1);
                }else {
                    user.setEnable(0);
                }
                user.setCreateTime(new Date());
                //UUID设置用户的id
                user.setId(UUID.randomUUID().toString().replace("-",""));
                //初始密码均设置a123456
                user.setPassword("a123456");

                for (int i1 = 0; i1 < allRoles.size(); i1++) {
                    Role role = allRoles.get(i1);
                    if (role.getName().equals(values[4])){
                        user.setRoleId(role.getId());
                    }
                }
                //若没有数据库中的角色，则直接添加为学生
                if (values[4].isEmpty()){
                    user.setRoleId("3");
                }
//                if (values[4].equals("管理员")){
//                    user.setRoleId("1");
//                }else if (values[4].equals("导师")){
//                    user.setRoleId("2");
//                }else if (values[4].equals("学生")){
//                    user.setRoleId("3");
//                }else if (values[4].equals("教学秘书")){
//                    user.setRoleId("a4ea24e68fc342c2a52286702061a022");
//                }
                userService.addUser(user);
            }
        }
        //前端可以通过状态码，判断文件是否上传成功
        return ResultUtil.result(EnumCode.OK.getValue(),"文件上传成功");
    }

    /**
     * 批量导入用户
     *
     */
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;
    @Autowired
    DictService dictService;
    @Autowired
    StudentService studentService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    StudentCourseTeacherService studentCourseTeacherService;
    @RequestMapping(value = "/courseImport")
    @ResponseBody
    @Transactional
    public Object courseExcelImport(@RequestParam("multipartFiles") MultipartFile[] multipartFiles,@RequestParam("instituteId2") String instituteId2,
                                    @RequestParam("ccourseType") String ccourseType,@RequestParam("majorId2") String majorId2,
                                    @RequestParam("clazzId2") String clazzId2, @RequestParam("validateStartTime") String validateStartTime,
                                    @RequestParam("validateEndTime") String validateEndTime) throws IOException {

        if (multipartFiles == null || multipartFiles.length < 1){
            return ResultUtil.result(EnumCode.INTERNAL_SERVER_ERROR.getValue(),"空数据，导入失败");
        }
        for (MultipartFile file : multipartFiles){
            List<String[]> list = ExcelUtil.readExcel(file);
            if (list.isEmpty()){
                return ResultUtil.result(EnumCode.INTERNAL_SERVER_ERROR.getValue(),"空数据，导入失败");
            }
            //查询数据库有么有这个实习类型，没有就新增
            Map<String,Object> map = new HashMap<>();
            map.put("start_stime",validateStartTime);
            map.put("end_etime",validateEndTime);
            map.put("course_type",ccourseType);
            String courseId = null;
            if (courseService.selectByMap(map).isEmpty()){
                Map<String,Object> map1 = new HashMap<>();
                map1.put("dict_code",ccourseType);
                List<SysDict> sysDicts = dictService.selectByMap(map1);
                Course course = new Course();
                course.setId(UUID.randomUUID().toString().replace("-",""));
                course.setName(sysDicts.get(0).getDictValue());
                course.setStartTime(validateStartTime);
                course.setEndTime(validateEndTime);
                course.setCourseType(ccourseType);
                courseService.insert(course);
                courseId = course.getId();
            }else {
                courseId = courseService.selectByMap(map).get(0).getId();
            }

            //查询数据库的所有角色并且赋值
            List<Role> allRoles = roleService.findAllRoles();
            String teacherName = null;
            String teacherPhone = null;
            String teacherId = null;
            List<Teacher> teachers = null;

            for (int i=0;i<list.size();i++){
                String[] values = list.get(i);
                //判断老师并且赋值
                if (!values[2].isEmpty() && !values[3].isEmpty()){
                    teacherName = values[2];
                    teacherPhone = values[3];

                    Map<String,Object> objectMap = new HashMap<>();
                    objectMap.put("name",teacherName);
                    objectMap.put("phone",teacherPhone);
                    teachers = teacherService.selectByMap(objectMap);
                    //没有这个老师就新建
                    if (teachers.size() == 0){
                        Teacher teacher = new Teacher();
                        teacher.setId(UUID.randomUUID().toString().replace("-",""));
                        teacher.setName(teacherName);
                        teacher.setPhone(teacherPhone);
                        teacher.setPhotoUrl("http://47.97.105.41/group1/M00/00/00/rB9y_2Hehg2AJ41ZAADMKjt4FbQ509.png");
                        teacher.setSex(1);//默认是男
                        teacherService.insert(teacher);
                        teacherId = teacher.getId();
                        //插入用户表
                        User user = new User();
                        user.setId(UUID.randomUUID().toString().replace("-",""));
                        user.setUsername(teacherPhone);
                        user.setName(teacherName);
                        user.setCreateTime(new Date());
                        user.setPassword("d477887b0636e5d87f79cc25c99d7dc9");//初始密码a123456
                        user.setEnable(1);
                        user.setPhotoUrl("http://47.97.105.41/group1/M00/00/00/rB9y_2Hehg2AJ41ZAADMKjt4FbQ509.png");
                        UserRole userRole = new UserRole();
                        userRole.setUserId(user.getId());
                        userRole.setRoleId("2");
                        userRoleService.insert(userRole);
                        userService.insert(user);

                    }else {
                        teacherId = teachers.get(0).getId();
                    }
                }
                //判断学生
                String studentName = values[0];
                String studentNick = values[1];
                String studentPhone = values[4];
                Map<String,Object> m = new HashMap<>();
                //学号是name，判断是否有这个学生
                m.put("name",studentName);
                List<Student> students = studentService.selectByMap(m);
                String studentId = null;
                if (students.size() == 0){
                    Student student = new Student();
                    student.setId(UUID.randomUUID().toString().replace("-",""));
                    student.setSex(1);//默认是男
                    student.setName(studentName);
                    student.setNickname(studentNick);
                    student.setPhone(studentPhone);
                    student.setClazzId(clazzId2);
                    student.setMajorId(majorId2);
                    student.setInstituteId(instituteId2);
                    student.setPhotoUrl("http://47.97.105.41/group1/M00/00/00/rB9y_2He0rSAeek1AABgUvgByVQ494.png");
                    studentService.insert(student);
                     studentId = student.getId();
                    //插入用户表
                    User user = new User();
                    user.setId(UUID.randomUUID().toString().replace("-",""));
                    user.setUsername(studentName);
                    user.setName(studentNick);
                    user.setCreateTime(new Date());
                    user.setPhotoUrl("http://47.97.105.41/group1/M00/00/00/rB9y_2He0rSAeek1AABgUvgByVQ494.png");
                    user.setPassword("d477887b0636e5d87f79cc25c99d7dc9");//初始密码a123456
                    user.setEnable(1);
                    userService.insert(user);
                    UserRole userRole = new UserRole();
                    userRole.setUserId(user.getId());
                    userRole.setRoleId("3");
                    userRoleService.insert(userRole);
                }else {
                     studentId = students.get(0).getId();
                }


                //插入实习,老师,学生表
                Map<String,Object> mm = new HashMap<>();
                mm.put("student_id",studentId);
                mm.put("teacher_id",teacherId);
                mm.put("course_id",courseId);
                List<StudentCourseTeacher> studentCourseTeachers = studentCourseTeacherService.selectByMap(mm);
                if (studentCourseTeachers.size() == 0){
                    StudentCourseTeacher studentCourseTeacher = new StudentCourseTeacher();
                    studentCourseTeacher.setCourseId(courseId);
                    studentCourseTeacher.setStudentId(studentId);
                    studentCourseTeacher.setTeacherId(teacherId);
                    studentCourseTeacherService.insert(studentCourseTeacher);
                }

            }
        }
        //前端可以通过状态码，判断文件是否上传成功
        return ResultUtil.result(EnumCode.OK.getValue(),"文件上传成功");
    }


}
