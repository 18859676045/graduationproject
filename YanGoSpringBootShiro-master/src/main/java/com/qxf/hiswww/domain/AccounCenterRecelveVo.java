package com.qxf.hiswww.domain;

import lombok.Data;


/**
 * @ Author 王炜雯
 * @ Date 2022/1/11  14:03
 */
@Data
public class AccounCenterRecelveVo {

    private String tid;
    private String tname;
    private String tsex;
    private Integer tage;
    private String tphone;
    private String temail;
    private String title2;
    //教学秘书
    private String jid;
    private String jname;
    private String jnickname;
    private String jsex;
    private Integer jage;
    private String jphone;
    private String jemail;
    //学生
    private String sid;
    private String clazzId;
    private String majorId;
    private String instituteId;
    private String snickname;
    private String semail;
    private String ssex;
    private String sname;
    private Integer sage;
    private String sphone;
}
