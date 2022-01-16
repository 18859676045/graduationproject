package com.qxf.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qxf.pojo.StudentCourseTeacher;

public interface StudentCourseTeacherMapper extends BaseMapper<StudentCourseTeacher> {
    int deleteByPrimaryKey(String id);

//    int insert(StudentCourseTeacher record);

    int insertSelective(StudentCourseTeacher record);

    int MyWriteInsert(StudentCourseTeacher record);


    StudentCourseTeacher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StudentCourseTeacher record);

    int updateByPrimaryKeyWithBLOBs(StudentCourseTeacher record);

    int updateByPrimaryKey(StudentCourseTeacher record);
}