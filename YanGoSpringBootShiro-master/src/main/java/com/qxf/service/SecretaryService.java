package com.qxf.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.qxf.pojo.FastDfs;
import com.qxf.pojo.Institute;
import com.qxf.pojo.Secretary;

import java.util.List;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/10  22:14
 */
public interface SecretaryService extends IService<Secretary> {
    List<Secretary> getSecretaryByPage(Page<Secretary> page, String name);

    Object insertSecretary(Secretary secretary);

    Object deleteSecretary(String[] ids);
}
