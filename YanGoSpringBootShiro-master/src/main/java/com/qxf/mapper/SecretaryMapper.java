package com.qxf.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qxf.pojo.Secretary;

public interface SecretaryMapper  extends BaseMapper<Secretary> {
    int deleteByPrimaryKey(String id);

//    int insert(Secretary record);

    int insertSelective(Secretary record);

    Secretary selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Secretary record);

    int updateByPrimaryKey(Secretary record);
}