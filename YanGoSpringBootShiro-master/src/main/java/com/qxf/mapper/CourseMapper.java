package com.qxf.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qxf.pojo.Course;
import com.qxf.pojo.ShixiCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: qiuxinfa
 * @Date: 2019/11/24
 * @Description: com.qxf.mapper
 */
public interface CourseMapper extends BaseMapper<Course>{

    //查询实习管理
    List<ShixiCourse> getListByPage(Page<ShixiCourse> page, @Param("name") String name);

    List<Course> getNotSelectedCourse(Page<Course> page, @Param("studentId") String studentId);

    List<Course> getSelectedCourse(Page<Course> page, @Param("studentId") String studentId);

    List<Course> getCourseByTeacher(Page<Course> page, @Param("teacherId") String teacherId);
}
