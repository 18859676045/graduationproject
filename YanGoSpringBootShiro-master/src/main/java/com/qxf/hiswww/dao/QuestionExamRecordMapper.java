package com.qxf.hiswww.dao;

import com.qxf.hiswww.domain.QuestionExamRecord;
import com.qxf.hiswww.domain.QuestionExamRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionExamRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    long countByExample(QuestionExamRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    int deleteByExample(QuestionExamRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    int insert(QuestionExamRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    int insertSelective(QuestionExamRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    QuestionExamRecord selectOneByExample(QuestionExamRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    QuestionExamRecord selectOneByExampleSelective(@Param("example") QuestionExamRecordExample example, @Param("selective") QuestionExamRecord.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    List<QuestionExamRecord> selectByExampleSelective(@Param("example") QuestionExamRecordExample example, @Param("selective") QuestionExamRecord.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    List<QuestionExamRecord> selectByExample(QuestionExamRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    QuestionExamRecord selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") QuestionExamRecord.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    QuestionExamRecord selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") QuestionExamRecord record, @Param("example") QuestionExamRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") QuestionExamRecord record, @Param("example") QuestionExamRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(QuestionExamRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_exam_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(QuestionExamRecord record);
}