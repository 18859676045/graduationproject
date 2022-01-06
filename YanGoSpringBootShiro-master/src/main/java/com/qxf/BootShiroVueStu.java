package com.qxf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Auther: WangWeiWen
 * @Date: 2021/11/17
 * @Description: com.qxf
 */
@SpringBootApplication
@MapperScan({"com.qxf.mapper","com.qxf.hiswww.dao"})
@EnableTransactionManagement
@EnableScheduling
public class BootShiroVueStu {
    public static void main(String[] args) {
        SpringApplication.run(BootShiroVueStu.class,args);
    }
}
