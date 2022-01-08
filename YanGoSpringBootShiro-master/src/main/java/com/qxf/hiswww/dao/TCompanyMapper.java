package com.qxf.hiswww.dao;

import com.qxf.hiswww.domain.TCompany;
import com.qxf.hiswww.domain.TCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCompanyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    long countByExample(TCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    int deleteByExample(TCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    int insert(TCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    int insertSelective(TCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    TCompany selectOneByExample(TCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    TCompany selectOneByExampleSelective(@Param("example") TCompanyExample example, @Param("selective") TCompany.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    TCompany selectOneByExampleWithBLOBs(TCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    List<TCompany> selectByExampleSelective(@Param("example") TCompanyExample example, @Param("selective") TCompany.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    List<TCompany> selectByExampleWithBLOBs(TCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    List<TCompany> selectByExample(TCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    TCompany selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") TCompany.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    TCompany selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TCompany record, @Param("example") TCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") TCompany record, @Param("example") TCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TCompany record, @Param("example") TCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(TCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_company
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TCompany record);
}