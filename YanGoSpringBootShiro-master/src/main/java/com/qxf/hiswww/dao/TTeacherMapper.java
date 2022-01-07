package com.qxf.hiswww.dao;

import com.qxf.hiswww.domain.TTeacher;
import com.qxf.hiswww.domain.TTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTeacherMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    long countByExample(TTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    int deleteByExample(TTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    int insert(TTeacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    int insertSelective(TTeacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    TTeacher selectOneByExample(TTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    TTeacher selectOneByExampleSelective(@Param("example") TTeacherExample example, @Param("selective") TTeacher.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    List<TTeacher> selectByExampleSelective(@Param("example") TTeacherExample example, @Param("selective") TTeacher.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    List<TTeacher> selectByExample(TTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    TTeacher selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") TTeacher.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    TTeacher selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TTeacher record, @Param("example") TTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TTeacher record, @Param("example") TTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TTeacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TTeacher record);
}