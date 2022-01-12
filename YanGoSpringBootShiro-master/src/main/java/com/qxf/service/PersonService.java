package com.qxf.service;

import com.qxf.hiswww.domain.AccounCenterRecelveVo;
import com.qxf.pojo.EditUserVo;
import com.qxf.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/9  23:48
 */
public interface PersonService{
    EditUserVo findPersonCenter(User user);
    public Integer updateMessage(String userId, String roleId, AccounCenterRecelveVo vo);
    }
