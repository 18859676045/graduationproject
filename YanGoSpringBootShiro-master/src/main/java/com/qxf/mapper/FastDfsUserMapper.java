package com.qxf.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qxf.pojo.FastDfsUser;

public interface FastDfsUserMapper extends BaseMapper<FastDfsUser> {
    int deleteByPrimaryKey(String id);

//    int insert(FastDfsUser record);

    int insertSelective(FastDfsUser record);

    FastDfsUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FastDfsUser record);

    int updateByPrimaryKey(FastDfsUser record);
}