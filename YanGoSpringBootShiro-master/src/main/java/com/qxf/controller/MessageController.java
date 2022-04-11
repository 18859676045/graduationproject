package com.qxf.controller;

import com.qxf.hiswww.domain.TUser;
import com.qxf.service.UserService;
import com.qxf.utils.EnumCode;
import com.qxf.utils.MailUtils;
import com.qxf.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/8  23:18
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    UserService userService;


    @RequestMapping("/send")
    public Object sendMessage(String email){
//        TUser tUser = userService.findbyId(id);
//        String email = tUser.getEmail();
//        String content="消息提醒："+tUser.getName()+"("+tUser.getUsername()+")"+
        String content=   "<br>您在阳光学院实习材料管理系统，还有资料未填完全请您尽快登陆！！" +
                "<br>谢谢";
        boolean mes = MailUtils.sendMail(email, content, "阳光学院实习材料管理系统的提醒");
        if (mes){
            return ResultUtil.result(EnumCode.OK.getValue(), "发送成功");
        }

        return ResultUtil.result(EnumCode.BAD_EMAIL.getValue(), "用户邮箱错误！！");
    }
}
