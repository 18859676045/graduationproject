package com.qxf.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qxf.pojo.FastDfs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FastDfsMapper extends BaseMapper<FastDfs> {
    int deleteByPrimaryKey(String id);

//    int insert(FastDfs record);

    int insertSelective(FastDfs record);

    FastDfs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FastDfs record);

    int updateByPrimaryKey(FastDfs record);

    List<FastDfs> getFastDfsByPage(Page<FastDfs> page, @Param("name") String name);
}