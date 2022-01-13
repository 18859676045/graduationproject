package com.qxf.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qxf.exception.MyException;
import com.qxf.mapper.ClazzMapper;
import com.qxf.mapper.SecretaryMapper;
import com.qxf.pojo.Clazz;
import com.qxf.pojo.Secretary;
import com.qxf.pojo.User;
import com.qxf.pojo.UserRole;
import com.qxf.service.ClazzService;
import com.qxf.service.SecretaryService;
import com.qxf.service.UserRoleService;
import com.qxf.service.UserService;
import com.qxf.utils.EnumCode;
import com.qxf.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/10  22:15
 */
@Service
public class SecretaryServiceImpl extends ServiceImpl<SecretaryMapper, Secretary> implements SecretaryService {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;


    @Override
    public List<Secretary> getSecretaryByPage(Page<Secretary> page, String name) {

        return super.baseMapper.getSecretaryByPage(page,name);
    }

    @Override
    public Object insertSecretary(Secretary secretary) {
        //判断教秘是否存在
        Map<String,Object> map = new HashMap<>();
        map.put("name",secretary.getName());
        map.put("username",secretary.getUsername());
        map.put("major_id",secretary.getMajorId());
        map.put("phone",secretary.getPhone());
        List<Secretary> list = super.baseMapper.selectByMap(map);
        if(list!=null && list.size()>0){
            throw new MyException(ResultUtil.result(EnumCode.BAD_REQUEST.getValue(),"该教秘已存在",null));
        }
        //插入教秘
        super.baseMapper.insert(secretary);
        //把教秘信息插入到t_user表和t_user_roel表，使得教秘可以用姓名和默认密码a123456登录
        User u = new User();
        u.setId(secretary.getId());
        u.setUsername(secretary.getName().trim());
        u.setPassword("d477887b0636e5d87f79cc25c99d7dc9");
        if(secretary.getPhotoUrl()!=null){
            u.setPhotoUrl(secretary.getPhotoUrl().trim());
        }
        if(secretary.getEmail()!=null){
            u.setEmail(secretary.getEmail().trim());
        }
        u.setEnable(1);
        u.setCreateTime(new Date());
        u.setName(secretary.getUsername());
        userService.insert(u);

        //再把user信息插入到_user_roel表中
        UserRole ur = new UserRole();
        ur.setUserId(u.getId());
        ur.setRoleId("4");  //角色为教秘
        userRoleService.insert(ur);
        return ResultUtil.result(EnumCode.OK.getValue(),"新增成功");

    }

    @Override
    public Object deleteSecretary(String[] ids) {
        //逐个删除
        for (String id : ids){
            baseMapper.deleteById(id);
        }

        return ResultUtil.result(EnumCode.OK.getValue(), "删除成功");

    }
}
