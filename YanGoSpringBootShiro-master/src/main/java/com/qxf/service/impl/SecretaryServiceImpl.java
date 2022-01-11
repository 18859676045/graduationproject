package com.qxf.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qxf.mapper.ClazzMapper;
import com.qxf.mapper.SecretaryMapper;
import com.qxf.pojo.Clazz;
import com.qxf.pojo.Secretary;
import com.qxf.service.ClazzService;
import com.qxf.service.SecretaryService;
import org.springframework.stereotype.Service;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/10  22:15
 */
@Service
public class SecretaryServiceImpl extends ServiceImpl<SecretaryMapper, Secretary> implements SecretaryService {
}
