package com.qxf.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @ Author 王炜雯
 * @ Date 2022/3/19  20:54
 */
public interface SystemService {
    void getCaptchaImage(HttpServletResponse response);
}
