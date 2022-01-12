package com.qxf.controller;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/9  23:38
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qxf.hiswww.domain.AccounCenterRecelveVo;
import com.qxf.pojo.EditUserVo;
import com.qxf.pojo.User;
import com.qxf.service.PersonService;
import com.qxf.utils.EnumCode;
import com.qxf.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 个人中心类
 */
@RestController
@RequestMapping("/account")
public class PersonCenterController extends BaseController{

    @Autowired
    PersonService personService;

    /**
     * 个人中心查找用户信息（教务秘书当作老师查询）
     * 1.管理员，老师，教书秘书查询
     * 2.学生查询
     * @param user
     * @return
     */
    @RequestMapping("/center")
    public Object center(User user){
        EditUserVo editUserVo = personService.findPersonCenter(user);
        Map<String,Object> map = new HashMap<>();
        map.put("map",editUserVo);
        if (StringUtils.isEmpty(editUserVo)){
            return ResultUtil.result(EnumCode.NO_PERSON.getValue(), "用户无信息", null);
        }
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", map);
    }
    /**
     * 修改个人信息，判断四个角色信息选择插入
     */
    @RequestMapping("/editMessage")
    public Object editMessage(AccounCenterRecelveVo recelveVo){
        String userId = super.getUserId();
        String roleId = super.getRoleId();
        Integer integer = personService.updateMessage(userId, roleId, recelveVo);
        if (integer==1){
            return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", "请求成功");
        }
         return ResultUtil.result(EnumCode.EXCPTION_ERROR.getValue(), "请求失败", null);
    }


}
