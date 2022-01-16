package com.qxf.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

@TableName("t_student_course_teacher")
@Data
public class StudentCourseTeacher implements Serializable {
//    @TableId(value = "id",type = IdType.INPUT)
    private String id;
    @TableField("student_id")
    private String studentId;
    @TableField("teacher_id")
    private String teacherId;
    @TableField("score")
    private Integer score;
    @TableField("course_id")
    private String courseId;
    @TableField("teacher_estimate")
    private String teacherEstimate;

}