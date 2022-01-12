package com.qxf.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qxf.pojo.FastDfs;
import com.qxf.pojo.FastDfsDel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FastDfsDelMapper extends BaseMapper<FastDfsDel> {
    int deleteByPrimaryKey(String id);

//    int insert(FastDfsDel record);

    int insertSelective(FastDfsDel record);

    FastDfsDel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FastDfsDel record);

    int updateByPrimaryKey(FastDfsDel record);

    List<FastDfsDel> getFastDfsDelByPage(Page<FastDfsDel> page,@Param("name") String name);
}