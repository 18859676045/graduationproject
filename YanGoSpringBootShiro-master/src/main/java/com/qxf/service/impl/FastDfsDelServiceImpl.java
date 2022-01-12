package com.qxf.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qxf.mapper.FastDfsDelMapper;
import com.qxf.pojo.FastDfs;
import com.qxf.pojo.FastDfsDel;
import com.qxf.service.FastDfsDelService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/12  15:20
 */
@Service
public class FastDfsDelServiceImpl extends ServiceImpl<FastDfsDelMapper, FastDfsDel> implements FastDfsDelService {
    @Override
    public List<FastDfsDel> getFastDfsDelByPage(Page<FastDfsDel> page, String name) {
        return super.baseMapper.getFastDfsDelByPage(page,name);
    }
}
