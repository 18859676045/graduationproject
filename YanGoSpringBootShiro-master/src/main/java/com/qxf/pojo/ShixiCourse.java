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
     private String studentNumber;
     private int score;
     private Date startStime;
     private String cname;
     private String tname;
     private Date endEtime;
     private String tphone;
    private String[] teacherIds;
}
