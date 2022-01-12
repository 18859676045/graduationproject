package com.qxf.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.qxf.pojo.FastDfs;

import java.util.List;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/11  1:12
 */
public interface FastDfsService extends IService<FastDfs> {
    List<FastDfs> getFastDfsByPage(Page<FastDfs> page, String name);

    Object deleteMaterials(String[] ids, String userId, String userName);
}
