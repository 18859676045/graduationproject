package com.qxf.hiswww.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/7  23:47
 */
@Data
public class ShiXiBigPojo {

    //公司表

    private String gid;

    private String gcompanyName;

    private String gstudentsPost;

    private String goutSupervisor;

    private String goutorPhone;

    private String gstudnetId;

    private String gcDescribe;

    private String supervisorPost;
    private String courseId;
    //老师表

    private String tid;

    private String tname;

    private Integer tsex;

    private Integer tage;

    private String ttitle;

    private String temail;

    private String tphotoUrl;

    private String tphone;

    //学生表

    private String sid;

    private String studentNumber;

    private String sname;

    private Integer ssex;

    private Integer sage;

    private String sphone;

    private String semail;

    private String sphotoUrl;

    private String sclazzId;

    private String smajorId;

    private String sinstituteId;

    //实习表

    private String cid;

    private String cname;

//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate cstartStime;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate cendEtime;

    private String ccourseType;
    //老师实习学生，成绩评价表
    private Integer score;
    private String stcId;
    private String teacherEstimate;
    //前端传来的接收,时间
    private String[] validateTime;

}
