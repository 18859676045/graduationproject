package com.qxf.controller;

import com.qxf.pojo.User;
import com.qxf.service.LoginLogService;
import com.qxf.service.UserService;
import com.qxf.utils.EnumCode;
import com.qxf.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping( "user")
public class LoginController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private LoginLogService loginLogService;

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @Autowired
    SystemController systemController;


    @PostMapping("/login")
    public Object login(String name,String pass,String verify , HttpSession session, HttpServletRequest request) {

        String cacheCaptcha = (String) session.getAttribute("check");
        if (verify.equals(cacheCaptcha)) {
            session.removeAttribute("check");
        } else {
            return ResultUtil.result(EnumCode.BAD_CHECK.getValue(), EnumCode.BAD_CHECK.getText());
        }
            User user = new User();
            user.setUsername(name);
            user.setPassword(pass);
            System.out.println(session);
            return userService.login(user, session, request);
        }


    @RequestMapping(value = "/loginOut",method = RequestMethod.GET)
    public Object logout() {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            return ResultUtil.result(EnumCode.OK.getValue(), "退出登陆成功");
        } catch (Exception e) {
            return "/login";
        }
    }
}

