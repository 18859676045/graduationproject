package com.qxf.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.qxf.pojo.FastDfs;
import com.qxf.pojo.FastDfsDel;

import java.util.List;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/12  15:20
 */
public interface FastDfsDelService extends IService<FastDfsDel> {
    List<FastDfsDel> getFastDfsDelByPage(Page<FastDfsDel> page, String name);
}
