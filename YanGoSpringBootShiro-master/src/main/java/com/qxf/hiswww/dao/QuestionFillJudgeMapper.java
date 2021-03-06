package com.qxf.hiswww.dao;

import com.qxf.hiswww.domain.QuestionFillJudge;
import com.qxf.hiswww.domain.QuestionFillJudgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionFillJudgeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    long countByExample(QuestionFillJudgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    int deleteByExample(QuestionFillJudgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    int insert(QuestionFillJudge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    int insertSelective(QuestionFillJudge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    QuestionFillJudge selectOneByExample(QuestionFillJudgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    QuestionFillJudge selectOneByExampleSelective(@Param("example") QuestionFillJudgeExample example, @Param("selective") QuestionFillJudge.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    List<QuestionFillJudge> selectByExampleSelective(@Param("example") QuestionFillJudgeExample example, @Param("selective") QuestionFillJudge.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    List<QuestionFillJudge> selectByExample(QuestionFillJudgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    QuestionFillJudge selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") QuestionFillJudge.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    QuestionFillJudge selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") QuestionFillJudge record, @Param("example") QuestionFillJudgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") QuestionFillJudge record, @Param("example") QuestionFillJudgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(QuestionFillJudge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_fill_judge
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(QuestionFillJudge record);
}