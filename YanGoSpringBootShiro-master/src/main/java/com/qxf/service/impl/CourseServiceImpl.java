package com.qxf.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qxf.exception.MyException;
import com.qxf.hiswww.dao.*;
import com.qxf.hiswww.domain.*;
import com.qxf.mapper.CourseMapper;
import com.qxf.pojo.*;
import com.qxf.service.*;
import com.qxf.utils.EnumCode;
import com.qxf.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Auther: qiuxinfa
 * @Date: 2019/11/24
 * @Description: com.qxf.service.impl
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper,Course> implements CourseService {
    @Autowired
    private CourseTeacherService courseTeacherService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    TCourseMapper tCourseMapper;
    @Autowired
    TCourseTeacherMapper tCourseTeacherMapper;
    @Autowired
    TStudentCourseTeacherMapper tStudentCourseTeacherMapper;
    @Autowired
    TStudentMapper tStudentMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    UserService userService;
    @Autowired
    SecretaryService secretaryService;
    @Autowired
    TeacherService teacherService;

    @Override
    public List<ShixiCourse> getListByPage(Page<ShixiCourse> page, String name) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        String roleId = user.getRoleId();
        if(roleId.equals("1")){
          return   courseMapper.getListByPage(page, name,null,null);
        }
        if (roleId.equals("2")){
            String teacherName = user.getUsername();
            Map<String,Object> map = new HashMap<>();
            map.put("phone",teacherName);
            List<Teacher> teachers = teacherService.selectByMap(map);
            return  courseMapper.getListByPage(page, name,teachers.get(0).getName(),null);
        }
        if (roleId.equals("3")){
            String studentName = user.getUsername();
            return  courseMapper.getListByPage(page, studentName,null,null);
        }
        if (roleId.equals("4")){
            String id = user.getId();
            Secretary secretary = secretaryService.selectById(id);
            String secretaryMajorId = secretary.getMajorId();
            return  courseMapper.getListByPage(page, name,null,secretaryMajorId);
        }
        return null;
    }
    public List<ShixiCourse> selectOutPut(String username,String userId,String roleId) {
//        Subject subject = SecurityUtils.getSubject();
//        User user = (User) subject.getPrincipal();
//        String roleId = user.getRoleId();
       String name = null;
        if(roleId.equals("1")){
            return   courseMapper.selectOutPut( name,null,null);
        }
        if (roleId.equals("2")){
//            String teacherName = user.getUsername();
            Map<String,Object> map = new HashMap<>();
            map.put("phone",username);
            List<Teacher> teachers = teacherService.selectByMap(map);
            return  courseMapper.selectOutPut(name,teachers.get(0).getName(),null);
        }
//        if (roleId.equals("3")){
//            String studentName = user.getName();
//            return  courseMapper.selectOutPut(studentName,null,null);
//        }
        if (roleId.equals("4")){
//            String id = user.getId();
            Secretary secretary = secretaryService.selectById(userId);
            String secretaryMajorId = secretary.getMajorId();
            return  courseMapper.selectOutPut(name,null,secretaryMajorId);
        }
        return null;
    }
    @Override
    public List<ShixiCourse> selectAll() {
        return courseMapper.selectAll();
    }


    @Autowired
    StudentCourseTeacherService sctService;
    @Autowired
    CourseService courseService;
    @Autowired
    DictService dictService;
    @Autowired
    StudentCourseTeacherService studentCourseTeacherService;

    @Transactional
    @Override
    public Object addCourse(ShixiCourse course) throws ParseException {

        //查询学生
        TStudentExample tStudentExample = new TStudentExample();
        tStudentExample.or().andNameEqualTo(course.getName()).andNicknameEqualTo(course.getNickname());

        TStudent tStudent = tStudentMapper.selectOneByExampleSelective(tStudentExample);
        if (StringUtils.isEmpty(tStudent)) {
            return ResultUtil.result(EnumCode.NO_PERSON.getValue(), "信息有误");
        }
        //查询实习类型课程
        Map<String,Object> courseMap = new HashMap<>();
        courseMap.put("start_stime",course.getStartStime());
        courseMap.put("end_etime",course.getEndEtime());
        courseMap.put("course_type",course.getCourseType());
        List<Course> courses = courseService.selectByMap(courseMap);
        Course TCourse = null;
        if(courses.size() == 0){
          Course courseOne = new Course();
          courseOne.setCourseType(course.getStartStime());
          courseOne.setStartTime(course.getStartStime());
          courseOne.setEndTime(course.getEndEtime());
          courseOne.setCourseType(course.getCourseType());
          Map<String,Object> dicMap = new HashMap<>();
          dicMap.put("dict_code",course.getCourseType());
          List<SysDict> sysDicts = dictService.selectByMap(dicMap);
          courseOne.setName(sysDicts.get(0).getDictValue());
            courseService.insert(courseOne);
          TCourse = courseOne;
        }else {
            TCourse = courses.get(0);
        }
        String tStudentId = tStudent.getId();
        Map<String,Object> map = new HashMap<>();
        map.put("student_id",tStudentId);
        String[] teacherids = course.getTeacherIds();
        map.put("teacher_id",teacherids[0]);
        map.put("course_id",course.getId());
        List<StudentCourseTeacher> studentCourseTeachers = sctService.selectByMap(map);
        if (studentCourseTeachers.size()!=0){
            return ResultUtil.result(EnumCode.EXIST_MESSAGE.getValue(), "已经存在该学生数据！请勿重复添加");
        }

        //插入t_student_course_teacher中间表，假设一门实习课程可以有多个任课老师
        String[] teacherIds = course.getTeacherIds();
        if (teacherIds != null && teacherIds.length > 0) {
            for (int i = 0; i < teacherIds.length; i++) {
                TStudentCourseTeacher tStudentCourseTeacher = new TStudentCourseTeacher();//新建中间表
                tStudentCourseTeacher.setCourseId(TCourse.getId());//插入课程ID
                try {
                    tStudentCourseTeacher.setStudentId(tStudent.getId());//插入学生id
                } catch (Exception e) {
                    return ResultUtil.result(EnumCode.NO_PERSON.getValue(), "没有这个学生", null);
                }
                tStudentCourseTeacher.setTeacherId(teacherIds[i]);//插入老师id
                tStudentCourseTeacher.setScore(course.getScore());//插入分数
                tStudentCourseTeacherMapper.insertSelective(tStudentCourseTeacher);
                Map<String,Object> map1 = new HashMap<>();
                map1.put("student_id",tStudent.getId());
                map1.put("teacher_id",teacherIds[i]);
                map1.put("course_id",TCourse.getId());
                List<StudentCourseTeacher> sctList = studentCourseTeacherService.selectByMap(map1);

                PracticeRisk practiceRisk = new PracticeRisk();
                practiceRisk.setId(sctList.get(0).getId());
                practiceRiskService.insert(practiceRisk);
            }
        }


        return ResultUtil.result(EnumCode.OK.getValue(), "新增成功");
    }

    @Override
    public Object deleteCourse(String[] ids) {
        try {
            for (int i = 0; i < ids.length; i++) {
                tStudentCourseTeacherMapper.deleteByPrimaryKey(ids[i]);
            }
        } catch (Exception e) {
            return ResultUtil.result(EnumCode.delete_error.getValue(), "删除失败");
        }
        return ResultUtil.result(EnumCode.OK.getValue(), "删除成功");
    }

    @Override
    public List<Course> getNotSelectedCourse(Page<Course> page, String studentId) {

        return super.baseMapper.getNotSelectedCourse(page, studentId);
    }

    @Override
    public List<Course> getSelectedCourse(Page<Course> page, String studentId) {
        return super.baseMapper.getSelectedCourse(page, studentId);
    }

    @Transactional
    @Override
    public Object addCourseToStudent(Course course) {
        String studentId = ((User) SecurityUtils.getSubject().getPrincipal()).getId();  //学生id
        String[] ctIds = course.getIds();    //课程-老师中间表的id
        Map<String, String> map = new HashMap<>();
        List<CourseTeacher> list = new ArrayList<>();
        //判断是否选择了一门课程的两个以上老师的课
        if (ctIds != null && ctIds.length > 0) {
            for (int i = 0; i < ctIds.length; i++) {
                CourseTeacher courseTeacher = courseTeacherService.selectById(ctIds[i]);
                if (map.containsValue(courseTeacher.getCourseId())) {
                    throw new MyException(ResultUtil.result(EnumCode.BAD_REQUEST.getValue(), "一门课程只能选择一个老师", null));
                }
                map.put("cid" + i, courseTeacher.getCourseId());
                list.add(courseTeacher);
            }
        }

        //将学生、课程、老师信息插入到成绩表中，表示该学生选了那些老师的那些课
        if (list != null && list.size() > 0) {
            for (CourseTeacher ct : list) {
                Grade grade = new Grade();
                grade.setStudentId(studentId);
                grade.setCourseId(ct.getCourseId());
                grade.setTeacherId(ct.getTeacherId());
                grade.setStatus(0);
                gradeService.insert(grade);
            }
        }
        return ResultUtil.result(EnumCode.OK.getValue(), "添加成功");
    }

    @Override
    public List<Course> getCourseByTeacher(Page<Course> page, String teacherId) {
        return super.baseMapper.getCourseByTeacher(page, teacherId);
    }



    /**
     * 所有用户：公司管理company,查看学生岗位详情
     */
    @Autowired
    TStudentCourseTeacherMapper tctmMapper;
    @Autowired
    TTeacherMapper tTeacherMapper;
    @Autowired
    TCompanyMapper tCompanyMapper;

    public ShiXiBigPojo findOnePost(String id) {

        TStudentCourseTeacher tsct = tctmMapper.selectByPrimaryKey(id);

        //实习信息
        TCourse tCourse = tCourseMapper.selectByPrimaryKey(tsct.getCourseId());
        //获取学生主键
        String studentId = tsct.getStudentId();
        //学生信息
        TStudent tStudent = tStudentMapper.selectByPrimaryKey(studentId);
        //老师信息
        TTeacher tTeacher = tTeacherMapper.selectByPrimaryKey(tsct.getTeacherId());
        //公司信息
        TCompanyExample tCompanyExample = new TCompanyExample();
        tCompanyExample.or().andStudnetIdEqualTo(studentId).andCourseIdEqualTo(tsct.getCourseId());
        TCompany company = tCompanyMapper.selectOneByExampleWithBLOBs(tCompanyExample);
        ShiXiBigPojo shiXiBigPojo = new ShiXiBigPojo();
        //老师实习学生，成绩评价表
        shiXiBigPojo.setScore(tsct.getScore());
        shiXiBigPojo.setStcId(tsct.getId());
        shiXiBigPojo.setTeacherEstimate(tsct.getTeacherEstimate());

        //公司表
        if (!StringUtils.isEmpty(company)) {
            shiXiBigPojo.setGid(company.getId());
            shiXiBigPojo.setGcompanyName(company.getCompanyName());
            shiXiBigPojo.setGstudentsPost(company.getStudentsPost());
            shiXiBigPojo.setGoutSupervisor(company.getOutSupervisor());
            shiXiBigPojo.setGoutorPhone(company.getOutorPhone());
            shiXiBigPojo.setGstudnetId(company.getStudnetId());
            shiXiBigPojo.setGcDescribe(company.getcDescribe());
            shiXiBigPojo.setSupervisorPost(company.getSupervisorPost());
            shiXiBigPojo.setCourseId(company.getCourseId());
        }
        //放入老师信息
        shiXiBigPojo.setTid(tTeacher.getId());
        shiXiBigPojo.setTname(tTeacher.getName());
        shiXiBigPojo.setTsex(tTeacher.getSex());
        shiXiBigPojo.setTage(tTeacher.getAge());
        shiXiBigPojo.setTtitle(tTeacher.getTitle());
        shiXiBigPojo.setTemail(tTeacher.getEmail());
        shiXiBigPojo.setTphotoUrl(tTeacher.getPhotoUrl());
        shiXiBigPojo.setTphone(tTeacher.getPhone());
        //放入学生信息表
        shiXiBigPojo.setSage(tStudent.getAge());
        shiXiBigPojo.setSid(tStudent.getId());
        shiXiBigPojo.setSemail(tStudent.getEmail());
        shiXiBigPojo.setSclazzId(tStudent.getClazzId());
        shiXiBigPojo.setSinstituteId(tStudent.getInstituteId());
        shiXiBigPojo.setSmajorId(tStudent.getMajorId());
        shiXiBigPojo.setSphotoUrl(tStudent.getPhotoUrl());
        shiXiBigPojo.setSphone(tStudent.getPhone());
        shiXiBigPojo.setSsex(tStudent.getSex());
        shiXiBigPojo.setNickname(tStudent.getNickname());
        shiXiBigPojo.setSname(tStudent.getName());
        //放入实习信息表
        shiXiBigPojo.setCid(tCourse.getId());
        shiXiBigPojo.setCcourseType(tCourse.getCourseType());
        shiXiBigPojo.setCendEtime(tCourse.getEndEtime());
        shiXiBigPojo.setCstartStime(tCourse.getStartStime());
        shiXiBigPojo.setCname(tCourse.getName());
//        Map<String,Object> practicMap = new HashMap<>();
//        practicMap.put("id",tsct.getId());
        PracticeRisk practiceRisk = practiceRiskService.selectById(tsct.getId());
        if (!StringUtils.isEmpty(practiceRisk)){
            shiXiBigPojo.setHealthy(practiceRisk.getHealthy());
           shiXiBigPojo.setPracticeWay(practiceRisk.getPracticeWay());
           shiXiBigPojo.setRisk(practiceRisk.getRisk());
       }
//        Map map = new HashMap();
        //封装四个数据集合
//        map.put("student",tStudent);map.put("teacher",tTeacher); map.put("company",company);map.put("course",tCourse);
        return shiXiBigPojo;
    }
    @Autowired
    PracticeRiskService practiceRiskService;
    @Autowired
    TSysDictMapper tSysDictMapper;
    @Autowired
    WCompanyMapper wCompanyMapper;
    @Autowired
    WCourseMapper wCourseMapper;

    //修改实习信息
    @Transactional
    public Object editBigPojo(ShiXiBigPojo shiXiBigPojo) {
        TStudentExample tStudentExample = new TStudentExample();
        tStudentExample.or().andNameEqualTo(shiXiBigPojo.getSname()).andNicknameEqualTo(shiXiBigPojo.getNickname());
        //查询是否有这个学生，进行修改
        TStudent tStudent = tStudentMapper.selectOneByExample(tStudentExample);
        if (StringUtils.isEmpty(tStudent)) {
            return ResultUtil.result(EnumCode.NO_STUDENT.getValue(), "没有这个学生", null);
        }
        //根据实习类型,实习的开始和结束的时间判断是否有这个实习，
        //如果没有这个实习课程则新增，有的话就直接获取主键(有bug)
//        TCourseExample tCourseExample = new TCourseExample();
//        LocalDate date1 = this.strConvertL(shiXiBigPojo.getValidateTime()[0]);
//        LocalDate date2 = this.strConvertL(shiXiBigPojo.getValidateTime()[1]);
//        String ccourseType = shiXiBigPojo.getCcourseType();
//        tCourseExample.or().andCourseTypeEqualTo(ccourseType)
//                .andStartStimeEqualTo(date1).
//                andEndEtimeEqualTo(date2);
        String date1 = shiXiBigPojo.getValidateTime()[0];
        String date2 = shiXiBigPojo.getValidateTime()[1];
        Course tCourse = tCourseMapper.myWriteSelectByStratEndType(date1,date2,shiXiBigPojo.getCcourseType());
//        Map<String,Object> practicMap = new HashMap<>();
//        practicMap.put("id",shiXiBigPojo.getStcId());
//        List<PracticeRisk> practiceRisks = practiceRiskService.selectByMap(practicMap);
        PracticeRisk practiceRisk = practiceRiskService.selectById(shiXiBigPojo.getStcId());
        if (!StringUtils.isEmpty(shiXiBigPojo.getPracticeWay())||!StringUtils.isEmpty(shiXiBigPojo.getRisk())||!StringUtils.isEmpty(shiXiBigPojo.getHealthy())){
            practiceRisk.setPracticeWay(shiXiBigPojo.getPracticeWay());
            practiceRisk.setRisk(shiXiBigPojo.getRisk());
            practiceRisk.setHealthy(shiXiBigPojo.getHealthy());
            practiceRiskService.updateById(practiceRisk);
        }else {
            return ResultUtil.result(EnumCode.RISK_NULL.getValue(),EnumCode.RISK_NULL.getText());
        }

        String courseId = null;
        //当为空时，新增一个实习课程course类
        if(StringUtils.isEmpty(tCourse)){
                WCourse course = new WCourse();
                course.setId(UUID.randomUUID().toString().replace("-",""));

                course.setStartStime(date1);
                course.setEndEtime(date2);
                String ccourseType = shiXiBigPojo.getCcourseType();
                //根据实习数据字典查询实习类型名称
                TSysDictExample tSysDictExample = new TSysDictExample();
                tSysDictExample.or().andDictCodeEqualTo(ccourseType);
                TSysDict sysDict = tSysDictMapper.selectOneByExample(tSysDictExample);
                course.setName(sysDict.getDictValue());
                course.setCourseType(ccourseType);
                wCourseMapper.insert(course);
                courseId = course.getId();
        }else {
            courseId = tCourse.getId();
        }

        //根据主键修改学生实习老师表
        TStudentCourseTeacher tStudentCourseTeacher = tStudentCourseTeacherMapper.selectByPrimaryKey(shiXiBigPojo.getStcId());
        tStudentCourseTeacher.setStudentId(tStudent.getId());
        tStudentCourseTeacher.setCourseId(courseId);
        tStudentCourseTeacher.setTeacherId(shiXiBigPojo.getTid());
        tStudentCourseTeacher.setScore(shiXiBigPojo.getScore());
        tStudentCourseTeacher.setTeacherEstimate(shiXiBigPojo.getTeacherEstimate());
        tStudentCourseTeacherMapper.updateByPrimaryKeySelective(tStudentCourseTeacher);
        //修改学生信息
        tStudent.setName(shiXiBigPojo.getSname());
        tStudent.setNickname(shiXiBigPojo.getNickname());
        tStudent.setEmail(shiXiBigPojo.getSemail());
        tStudent.setPhone(shiXiBigPojo.getSphone());
        tStudentMapper.updateByPrimaryKeySelective(tStudent);
        //修改公司信息
        String companyId = shiXiBigPojo.getGid();
        TCompany tCompany = tCompanyMapper.selectByPrimaryKey(companyId);
        //公司没信息则新插入
        if (StringUtils.isEmpty(tCompany)) {
            WCompany company = new WCompany();
            company.setId(UUID.randomUUID().toString().replace("-",""));
            company.setCompanyName(shiXiBigPojo.getGcompanyName());
            company.setStudentsPost(shiXiBigPojo.getGstudentsPost());
            company.setcDescribe(shiXiBigPojo.getGcDescribe());
            company.setOutSupervisor(shiXiBigPojo.getGoutSupervisor());
            company.setSupervisorPost(shiXiBigPojo.getSupervisorPost());
            company.setOutorPhone(shiXiBigPojo.getGoutorPhone());
            company.setStudnetId(tStudent.getId());
            company.setCourseId(courseId);
            wCompanyMapper.insertSelective(company);
        } else {
            //有信息则根据主键修改
            tCompany.setCompanyName(shiXiBigPojo.getGcompanyName());
            tCompany.setStudentsPost(shiXiBigPojo.getGstudentsPost());
            tCompany.setcDescribe(shiXiBigPojo.getGcDescribe());
            tCompany.setOutSupervisor(shiXiBigPojo.getGoutSupervisor());
            tCompany.setSupervisorPost(shiXiBigPojo.getSupervisorPost());
            tCompany.setOutorPhone(shiXiBigPojo.getGoutorPhone());
            tCompany.setStudnetId(tStudent.getId());
            tCompany.setCourseId(courseId);
            tCompanyMapper.updateByPrimaryKeySelective(tCompany);
        }
        //修改老师表
        TTeacher tTeacher = tTeacherMapper.selectByPrimaryKey(shiXiBigPojo.getTid());
        tTeacher.setEmail(shiXiBigPojo.getTemail());
        tTeacher.setPhone(shiXiBigPojo.getTphone());
        tTeacherMapper.updateByPrimaryKeySelective(tTeacher);

        return ResultUtil.result(EnumCode.OK.getValue(), "添加成功");
    }

    public static LocalDate strConvertD(String dateStr) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate parse = LocalDate.parse(dateStr, fmt);
            return parse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //localdate转换字符串
    public static String lformattedStr(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }





}
