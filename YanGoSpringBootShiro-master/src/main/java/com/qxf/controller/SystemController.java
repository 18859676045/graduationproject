package com.qxf.controller;


import com.qxf.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
/**
 * @ Author 王炜雯
 * @ Date 2022/3/19  20:58
 */
@RestController
public class SystemController {
    private SystemService systemService;

    @Autowired
    public void setSystemService(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping("/captcha/image")
    public void getCaptchaImage(HttpServletResponse response) {
        systemService.getCaptchaImage(response);
    }
}
