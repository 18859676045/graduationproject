package com.qxf.hiswww.dao;

import com.qxf.hiswww.domain.TOperateRecord;
import com.qxf.hiswww.domain.TOperateRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOperateRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    long countByExample(TOperateRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    int deleteByExample(TOperateRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    int insert(TOperateRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    int insertSelective(TOperateRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    TOperateRecord selectOneByExample(TOperateRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    TOperateRecord selectOneByExampleSelective(@Param("example") TOperateRecordExample example, @Param("selective") TOperateRecord.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    List<TOperateRecord> selectByExampleSelective(@Param("example") TOperateRecordExample example, @Param("selective") TOperateRecord.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    List<TOperateRecord> selectByExample(TOperateRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    TOperateRecord selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") TOperateRecord.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    TOperateRecord selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TOperateRecord record, @Param("example") TOperateRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TOperateRecord record, @Param("example") TOperateRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TOperateRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_operate_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TOperateRecord record);
}