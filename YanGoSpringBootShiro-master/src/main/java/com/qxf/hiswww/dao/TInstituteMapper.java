package com.qxf.hiswww.dao;

import com.qxf.hiswww.domain.TInstitute;
import com.qxf.hiswww.domain.TInstituteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TInstituteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    long countByExample(TInstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    int deleteByExample(TInstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    int insert(TInstitute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    int insertSelective(TInstitute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    TInstitute selectOneByExample(TInstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    TInstitute selectOneByExampleSelective(@Param("example") TInstituteExample example, @Param("selective") TInstitute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    List<TInstitute> selectByExampleSelective(@Param("example") TInstituteExample example, @Param("selective") TInstitute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    List<TInstitute> selectByExample(TInstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    TInstitute selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") TInstitute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    TInstitute selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TInstitute record, @Param("example") TInstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TInstitute record, @Param("example") TInstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TInstitute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_institute
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TInstitute record);
}