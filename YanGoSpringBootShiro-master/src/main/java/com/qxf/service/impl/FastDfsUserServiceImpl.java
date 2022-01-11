package com.qxf.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.qxf.mapper.FastDfsUserMapper;

import com.qxf.pojo.FastDfs;
import com.qxf.pojo.FastDfsUser;
import com.qxf.service.FastDfsService;
import com.qxf.service.FastDfsUserService;
import org.springframework.stereotype.Service;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/11  1:22
 */
@Service
public class FastDfsUserServiceImpl  extends ServiceImpl<FastDfsUserMapper, FastDfsUser> implements FastDfsUserService {
}
