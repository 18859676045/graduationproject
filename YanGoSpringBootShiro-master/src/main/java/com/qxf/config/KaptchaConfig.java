package com.qxf.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.util.Properties;
/**
 * @ Author 王炜雯
 * @ Date 2022/3/19  20:53
 */
@Component
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha defaultKaptcha() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 这里有很多个配置项，不自定义则使用默认配置
        properties.setProperty(Constants.KAPTCHA_BORDER_COLOR,  "black");
        // ...
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}

