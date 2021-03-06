package com.qxf.hiswww.dao;

import com.qxf.hiswww.domain.TStudentCourseTeacher;
import com.qxf.hiswww.domain.TStudentCourseTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStudentCourseTeacherMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    long countByExample(TStudentCourseTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    int deleteByExample(TStudentCourseTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    int insert(TStudentCourseTeacher record);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    int insertSelective(TStudentCourseTeacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    TStudentCourseTeacher selectOneByExample(TStudentCourseTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    TStudentCourseTeacher selectOneByExampleSelective(@Param("example") TStudentCourseTeacherExample example, @Param("selective") TStudentCourseTeacher.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    TStudentCourseTeacher selectOneByExampleWithBLOBs(TStudentCourseTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    List<TStudentCourseTeacher> selectByExampleSelective(@Param("example") TStudentCourseTeacherExample example, @Param("selective") TStudentCourseTeacher.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    List<TStudentCourseTeacher> selectByExampleWithBLOBs(TStudentCourseTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    List<TStudentCourseTeacher> selectByExample(TStudentCourseTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    TStudentCourseTeacher selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") TStudentCourseTeacher.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    TStudentCourseTeacher selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TStudentCourseTeacher record, @Param("example") TStudentCourseTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") TStudentCourseTeacher record, @Param("example") TStudentCourseTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TStudentCourseTeacher record, @Param("example") TStudentCourseTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TStudentCourseTeacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(TStudentCourseTeacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_student_course_teacher
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TStudentCourseTeacher record);
}