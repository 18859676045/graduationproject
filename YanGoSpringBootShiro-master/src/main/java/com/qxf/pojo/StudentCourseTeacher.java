package com.qxf.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("t_student_course_teacher")
public class StudentCourseTeacher {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTeacherEstimate() {
        return teacherEstimate;
    }

    public void setTeacherEstimate(String teacherEstimate) {
        this.teacherEstimate = teacherEstimate;
    }
}