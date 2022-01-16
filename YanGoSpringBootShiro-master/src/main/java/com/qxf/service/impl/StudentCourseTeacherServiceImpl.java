package com.qxf.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qxf.mapper.StudentCourseTeacherMapper;
import com.qxf.pojo.StudentCourseTeacher;
import com.qxf.service.StudentCourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @ Author 王炜雯
 * @ Date 2022/1/14  0:43
 */
@Service
public class StudentCourseTeacherServiceImpl extends ServiceImpl<StudentCourseTeacherMapper,StudentCourseTeacher>
        implements StudentCourseTeacherService {

    @Autowired
    StudentCourseTeacherMapper studentCourseTeacherMapper;

    @Override
    public int MyWriterInsert(StudentCourseTeacher studentCourseTeacher) {
        return studentCourseTeacherMapper.MyWriteInsert(studentCourseTeacher);
    }
}
