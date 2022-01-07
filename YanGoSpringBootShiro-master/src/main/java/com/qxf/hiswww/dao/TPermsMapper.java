package com.qxf.hiswww.dao;

import com.qxf.hiswww.domain.TPerms;
import com.qxf.hiswww.domain.TPermsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPermsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    long countByExample(TPermsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    int deleteByExample(TPermsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    int insert(TPerms record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    int insertSelective(TPerms record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    TPerms selectOneByExample(TPermsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    TPerms selectOneByExampleSelective(@Param("example") TPermsExample example, @Param("selective") TPerms.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    List<TPerms> selectByExampleSelective(@Param("example") TPermsExample example, @Param("selective") TPerms.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    List<TPerms> selectByExample(TPermsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    TPerms selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") TPerms.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    TPerms selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TPerms record, @Param("example") TPermsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TPerms record, @Param("example") TPermsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TPerms record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_perms
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TPerms record);
}