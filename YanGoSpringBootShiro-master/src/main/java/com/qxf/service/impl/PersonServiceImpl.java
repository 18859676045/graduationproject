package com.qxf.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.qxf.hiswww.dao.TUserMapper;
import com.qxf.hiswww.domain.AccounCenterRecelveVo;
import com.qxf.hiswww.domain.TUser;
import com.qxf.hiswww.domain.TUserExample;
import com.qxf.pojo.*;
import com.qxf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
            map.put("phone",user.getUsername());
            Teacher teacher = teacherService.selectById(user.getId());
            if (!StringUtils.isEmpty(teacher)) {
                editUserVo.setTeacher(teacher);
                if (!StringUtils.isEmpty(teacher.getTitle())){
                    Map<String,Object> map2 = new HashMap<>();
                    map2.put("dict_code",teacher.getTitle());
                    List<SysDict> sysDicts = dictService.selectByMap(map2);
                    SysDict sysDict = sysDicts.get(0);
                    editUserVo.setTeacherPost(sysDict.getDictValue());
                }
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
    /**
     * 修改角色信息
     * 1.判断角色，roleId
     * 2.修改对应的表（管理员与其他不用修改）
     * 3。返回成功的信息
     * （判断roleid为：2.导师3.学生4.教学秘书）
     * 返回1成功，返回1失败
     */
    @Autowired
    TUserMapper tUserMapper;
    @Transactional
    public Integer updateMessage(String userId, String roleId, AccounCenterRecelveVo vo){
        User user = userService.selectById(userId);
        String username = user.getUsername();
        boolean result = false;
        //老师
        if (roleId.equals("2")){
            //修改teacher表
            Teacher teacher = teacherService.selectById(userId);
            teacher.setEmail(vo.getTemail());
            teacher.setName(vo.getTname());
            //查询职称并赋值
            Map<String,Object> dicmap = new HashMap<>();
            dicmap.put("dict_code",vo.getTitle2());
            List<SysDict> sysDicts = dictService.selectByMap(dicmap);
            teacher.setTitleName(sysDicts.get(0).getDictValue());
            teacher.setTitle(vo.getTitle2());
            teacher.setAge(vo.getTage());
            teacher.setSex(Integer.valueOf(vo.getTsex()));
            teacher.setPhone(vo.getTphone());
            user.setEmail(vo.getTemail());
            user.setName(vo.getTname());
             result = teacherService.updateById(teacher);
        }
        //学生
        else if (roleId.equals("3")){
            Student student = studentService.selectById(userId);
            student.setInstituteId(vo.getInstituteId());
            student.setMajorId(vo.getMajorId());
            student.setClazzId(vo.getClazzId());
            student.setName(vo.getSname());
            student.setNickname(vo.getSnickname());
            student.setEmail(vo.getSemail());
            student.setSex(Integer.valueOf(vo.getSsex()));
            student.setAge(vo.getSage());
            student.setPhone(vo.getSphone());
            user.setEmail(vo.getSemail());
            user.setName(vo.getSnickname());
            result = studentService.updateById(student);

        }
        //教学秘书
       else if (roleId.equals("4")){
            Secretary secretary = secretaryService.selectById(userId);
            secretary.setEmail(vo.getJemail());
            secretary.setName(vo.getJname());
            secretary.setNickname(vo.getJnickname());
            secretary.setAge(vo.getJage());
            secretary.setPhone(vo.getJphone());
            secretary.setSex(vo.getJsex());
            secretary.setMajorId(vo.getMajorId());
            user.setEmail(vo.getJemail());
            user.setName(vo.getJnickname());
             result = secretaryService.updateById(secretary);
        }
       else {
           //管理员和其他角色不修改
           result = true;
        }
//       TUserExample tUserExample = new TUserExample();
//       tUserExample.or().andUsernameEqualTo(user.getUsername());
//       TUser tUser = tUserMapper.selectOneByExample(tUserExample);
//       if (tUser.getId().isEmpty()){
//           return 0;
//       }else {
//
//       }
        boolean b = userService.updateById(user);
       if (b && result){
           return 1;
       }
       return 0;
    }




}
