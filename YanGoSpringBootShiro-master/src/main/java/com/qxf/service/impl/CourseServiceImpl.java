package com.qxf.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qxf.exception.MyException;
import com.qxf.hiswww.dao.TCourseMapper;
import com.qxf.hiswww.dao.TCourseTeacherMapper;
import com.qxf.hiswww.dao.TStudentCourseTeacherMapper;
import com.qxf.hiswww.dao.TStudentMapper;
import com.qxf.hiswww.domain.*;
import com.qxf.mapper.CourseMapper;
import com.qxf.pojo.*;
import com.qxf.service.CourseService;
import com.qxf.service.CourseTeacherService;
import com.qxf.service.GradeService;
import com.qxf.utils.EnumCode;
import com.qxf.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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



    @Override
    public List<ShixiCourse> getListByPage(Page<ShixiCourse> page, String name) {
//        TStudentExample tStudentExample = new TStudentExample();
//        tStudentExample.or().andNameLike(name);
//        TStudent Students = tStudentMapper.selectOneByExample(tStudentExample);
//        TStudentCourseTeacherExample st= new TStudentCourseTeacherExample();
//        st.or().andStudentIdEqualTo(Students.getId());
//        tStudentCourseTeacherMapper.selectByExample(st);

        return courseMapper.getListByPage(page,name);
    }

    public List<Course> selectCourseByPage(Page<Course> page,String name){
        return null;
    }


    @Transactional
    @Override
    public Object addCourse(ShixiCourse course) throws ParseException {
        //查询学生
        TStudentExample tStudentExample = new TStudentExample();
        tStudentExample.or().andNameEqualTo(course.getName());
        TStudent tStudent = tStudentMapper.selectOneByExampleSelective(tStudentExample);
        //查询实习类型课程
        String courseType = course.getCourseType();
        TCourseExample tCourseExample = new TCourseExample();
        tCourseExample.or().andCourseTypeEqualTo(courseType);
        TCourse tCourse = tCourseMapper.selectOneByExample(tCourseExample);

        //插入t_student_course_teacher中间表，一门课程可以有多个任课老师
        String[] teacherIds = course.getTeacherIds();
        if(teacherIds!=null && teacherIds.length>0){
            for (int i=0;i<teacherIds.length;i++){
                TStudentCourseTeacher tStudentCourseTeacher = new TStudentCourseTeacher();//新建中间表
                tStudentCourseTeacher.setCourseId(tCourse.getId());//插入课程ID
                try {
                    tStudentCourseTeacher.setStudentId(tStudent.getId());//插入学生id
                }catch (Exception e){
                        return ResultUtil.result(EnumCode.NO_PERSON.getValue(), "没有这个学生",null);
                }

                tStudentCourseTeacher.setTeacherId(teacherIds[i]);//插入老师id
                tStudentCourseTeacher.setScore(course.getScore());//插入分数
                tStudentCourseTeacherMapper.insert(tStudentCourseTeacher);
            }
        }



        return ResultUtil.result(EnumCode.OK.getValue(),"新增成功");
    }

    @Override
    public Object deleteCourse(String[] ids) {
        try {
            for (int i = 0; i < ids.length; i++) {
                tStudentCourseTeacherMapper.deleteByPrimaryKey(ids[i]);
            }
        }catch (Exception e){
            return ResultUtil.result(EnumCode.delete_error.getValue(), "删除失败");
        }
        return ResultUtil.result(EnumCode.OK.getValue(), "删除成功");
    }

    @Override
    public List<Course> getNotSelectedCourse(Page<Course> page, String studentId) {

        return super.baseMapper.getNotSelectedCourse(page,studentId);
    }

    @Override
    public List<Course> getSelectedCourse(Page<Course> page, String studentId) {
        return super.baseMapper.getSelectedCourse(page,studentId);
    }

    @Transactional
    @Override
    public Object addCourseToStudent(Course course) {
        String studentId = ((User) SecurityUtils.getSubject().getPrincipal()).getId();  //学生id
        String[] ctIds = course.getIds();    //课程-老师中间表的id
        Map<String,String> map = new HashMap<>();
        List<CourseTeacher> list = new ArrayList<>();
        //判断是否选择了一门课程的两个以上老师的课
        if(ctIds != null && ctIds.length>0){
            for (int i=0;i<ctIds.length;i++){
                CourseTeacher courseTeacher = courseTeacherService.selectById(ctIds[i]);
                if(map.containsValue(courseTeacher.getCourseId())){
                    throw new MyException(ResultUtil.result(EnumCode.BAD_REQUEST.getValue(), "一门课程只能选择一个老师", null));
                }
                map.put("cid"+i,courseTeacher.getCourseId());
                list.add(courseTeacher);
            }
        }

        //将学生、课程、老师信息插入到成绩表中，表示该学生选了那些老师的那些课
        if(list != null && list.size()>0){
            for (CourseTeacher ct: list){
                Grade grade = new Grade();
                grade.setStudentId(studentId);
                grade.setCourseId(ct.getCourseId());
                grade.setTeacherId(ct.getTeacherId());
                grade.setStatus(0);
                gradeService.insert(grade);
            }
        }
        return ResultUtil.result(EnumCode.OK.getValue(),"添加成功");
    }

    @Override
    public List<Course> getCourseByTeacher(Page<Course> page, String teacherId) {
        return super.baseMapper.getCourseByTeacher(page,teacherId);
    }
}
