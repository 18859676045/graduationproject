package com.qxf.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qxf.pojo.FastDfs;

public interface FastDfsMapper extends BaseMapper<FastDfs> {
    int deleteByPrimaryKey(String id);

//    int insert(FastDfs record);

    int insertSelective(FastDfs record);

    FastDfs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FastDfs record);

    int updateByPrimaryKey(FastDfs record);
}