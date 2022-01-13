package com.qxf.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qxf.pojo.Secretary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecretaryMapper extends BaseMapper<Secretary> {
    int deleteByPrimaryKey(String id);

//    int insert(Secretary record);

    int insertSelective(Secretary record);

    Secretary selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Secretary record);

    int updateByPrimaryKey(Secretary record);

    List<Secretary> getSecretaryByPage(Page<Secretary> page,@Param("name") String name);
}