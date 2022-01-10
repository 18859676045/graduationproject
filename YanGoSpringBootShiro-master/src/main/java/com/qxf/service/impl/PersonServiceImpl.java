package com.qxf.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.qxf.hiswww.domain.TUser;
import com.qxf.pojo.*;
import com.qxf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/9  23:49
 */
@Service
public class PersonServiceImpl implements PersonService {
    /**
     *       id:user.id,
     *                 roleId:user.roleId,
     *                 roleName:user.roleName,
     *                 username:user.username
     * @param user
     * @return
     */
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;
    @Autowired
    DictService dictService;
    @Autowired
    InstituteService instituteService;
    @Autowired
    MajorService majorService;
    @Autowired
    ClazzService clazzService;
    @Autowired
    SecretaryService secretaryService;

    @Override
    public EditUserVo findPersonCenter(User user) {
        //先判断参数是否都有，否则抛出异常
        if (StringUtils.isEmpty(user.getId()) &&
                StringUtils.isEmpty(user.getRoleId()) && StringUtils.isEmpty(user.getUsername())) {
            return null;
        }
        EditUserVo editUserVo = new EditUserVo();
        //根据权限id查找角色
        Role role = roleService.selectById(user.getRoleId());
        //管理员，老师
        if (role.getId().equals("1") || role.getId().equals("2")){
            Map<String,Object> map = new HashMap<>();
            map.put("name",user.getUsername());
            List<Teacher> teachers = teacherService.selectByMap(map);
            if (teachers.size()!=0) {
                Teacher teacher = teachers.get(0);
                editUserVo.setTeacher(teacher);
                Map<String,Object> map2 = new HashMap<>();
                map2.put("dict_code",teacher.getTitle());
                List<SysDict> sysDicts = dictService.selectByMap(map2);
                SysDict sysDict = sysDicts.get(0);
                editUserVo.setTeacherPost(sysDict.getDictValue());
            }
        }
        //,教务秘书
         if ( role.getId().equals("4")){
            Map<String,Object> map = new HashMap<>();
            map.put("name",user.getUsername());
            List<Secretary> secretaries = secretaryService.selectByMap(map);
            if (secretaries.size()!=0){
                Secretary secretary = secretaries.get(0);
                String majorId = secretary.getMajorId();
                Major major = majorService.selectById(majorId);
                editUserVo.setSecretary(secretary);
                editUserVo.setMajor(major);
            }
        }
        if (role.getId().equals("3")){
            //.学生
            Map<String,Object> map = new HashMap<>();
            map.put("name",user.getUsername());
            List<Student> students = studentService.selectByMap(map);
            if (students.size()!=0){
                Student student = students.get(0);
                editUserVo.setStudent(student);
                String clazzId = student.getClazzId();
                Clazz clazz = clazzService.selectById(clazzId);
                String instituteId = student.getInstituteId();
                Institute institute = instituteService.selectById(instituteId);
                String majorId = student.getMajorId();
                Major major = majorService.selectById(majorId);
                editUserVo.setInstitute(institute);
                editUserVo.setClazz(clazz);
                editUserVo.setMajor(major);
            }
        }
        //角色,用户
        User u = userService.selectById(user.getId());
        editUserVo.setUser(u);
        editUserVo.setRole(role);
        return editUserVo;
    }
}
