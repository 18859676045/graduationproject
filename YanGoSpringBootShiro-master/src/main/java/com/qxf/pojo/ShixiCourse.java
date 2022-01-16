package com.qxf.pojo;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

import java.util.Date;
/**
 * @ Author 王炜雯
 * @ Date 2022/1/6  15:35
 */

//s.id,s.name,s.phone,sct.score,c.start_stime,c.`name` As cname,c.end_etime,t.`name` AS tname,t.phone
@Data
public class ShixiCourse {
     private String id;
     private String name;
     private String phone;
     private String sEmail;
     private String tEmail;
     private String courseType;
     private String nickname;
     private int score;
     private String startStime;
     private String cname;
     private String tname;
     private String endEtime;
     private String tphone;
     private String[] teacherIds;
     private String sinstituteId;
     private String smajorId;
     private String sclazzId;
     private String TeacherPost;

     //拓展的疫情情况表
     private String practiceWay;
    private String risk;
    private String healthy;
    //公司表
    private String companyName;
    private String studentsPost;
    private String outsupervisor;
    private String supervisorPost;
    private String outorPhone;





}
