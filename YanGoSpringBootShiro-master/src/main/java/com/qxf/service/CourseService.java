package com.qxf.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.qxf.hiswww.domain.ShiXiBigPojo;
import com.qxf.pojo.Course;
import com.qxf.pojo.ShixiCourse;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: qiuxinfa
 * @Date: 2019/11/24
 * @Description: com.qxf.service
 */
public interface CourseService extends IService<Course>{
    List<ShixiCourse> getListByPage(Page<ShixiCourse> page, String name);

    Object addCourse(ShixiCourse course) throws ParseException;

    ShiXiBigPojo findOnePost(String id);

    Object deleteCourse(String[] ids);

    List<Course> getNotSelectedCourse(Page<Course> page, String studentId);

    List<Course> getSelectedCourse(Page<Course> page, String studentId);

    Object addCourseToStudent(Course course);

    List<Course> getCourseByTeacher(Page<Course> page,String teacherId);

}
