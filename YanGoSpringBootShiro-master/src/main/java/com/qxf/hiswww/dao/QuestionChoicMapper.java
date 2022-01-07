package com.qxf.hiswww.dao;

import com.qxf.hiswww.domain.QuestionChoic;
import com.qxf.hiswww.domain.QuestionChoicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionChoicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    long countByExample(QuestionChoicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    int deleteByExample(QuestionChoicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    int insert(QuestionChoic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    int insertSelective(QuestionChoic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    QuestionChoic selectOneByExample(QuestionChoicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    QuestionChoic selectOneByExampleSelective(@Param("example") QuestionChoicExample example, @Param("selective") QuestionChoic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    List<QuestionChoic> selectByExampleSelective(@Param("example") QuestionChoicExample example, @Param("selective") QuestionChoic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    List<QuestionChoic> selectByExample(QuestionChoicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    QuestionChoic selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") QuestionChoic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    QuestionChoic selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") QuestionChoic record, @Param("example") QuestionChoicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") QuestionChoic record, @Param("example") QuestionChoicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(QuestionChoic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_choic
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(QuestionChoic record);
}