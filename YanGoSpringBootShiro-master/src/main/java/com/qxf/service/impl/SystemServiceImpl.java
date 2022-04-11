package com.qxf.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.qxf.service.SystemService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * @ Author 王炜雯
 * @ Date 2022/3/19  20:55
 */
@Service
public class SystemServiceImpl implements SystemService {

    private DefaultKaptcha defaultKaptcha;

    @Autowired
    public void setDefaultKaptcha(DefaultKaptcha defaultKaptcha) {
        this.defaultKaptcha = defaultKaptcha;
    }

    @Override
    public void getCaptchaImage(HttpServletResponse response) {
        String text = defaultKaptcha.createText();
        // 这里使用的是shiro，所以存入session中，也可以存入redis
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("check", text);
        BufferedImage image = defaultKaptcha.createImage(text);
        try {
            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
