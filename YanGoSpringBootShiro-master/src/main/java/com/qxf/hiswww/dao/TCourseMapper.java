package com.qxf.hiswww.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qxf.hiswww.domain.TCourse;
import com.qxf.hiswww.domain.TCourseExample;
import java.util.List;

import com.qxf.pojo.Course;
import org.apache.ibatis.annotations.Param;

public interface TCourseMapper{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    long countByExample(TCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    int deleteByExample(TCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    int insert(TCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    int insertSelective(TCourse record);

    int myWriteinsertSelective(TCourse record);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    TCourse selectOneByExample(TCourseExample example);

    Course myWriteSelectByStratEndType(@Param("startStime") String startStime, @Param("endEtime") String endEtime, @Param("courseType") String courseType);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    TCourse selectOneByExampleSelective(@Param("example") TCourseExample example, @Param("selective") TCourse.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    List<TCourse> selectByExampleSelective(@Param("example") TCourseExample example, @Param("selective") TCourse.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    List<TCourse> selectByExample(TCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    TCourse selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") TCourse.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    TCourse selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TCourse record, @Param("example") TCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TCourse record, @Param("example") TCourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TCourse record);
}