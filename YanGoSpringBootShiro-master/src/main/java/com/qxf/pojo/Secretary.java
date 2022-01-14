package com.qxf.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("t_secretary")
public class Secretary {
    private String id;
    private String name;
    private String sex;
    private Integer age;
    @TableField("institute_id")
    private String instituteId;
    private String email;
    @TableField("photo_url")
    private String photoUrl;
    private String phone;
    @TableField("major_id")
    private String majorId;
    private String nickname;
    @TableField(exist = false)
    private String[] ids;//id集合
    @TableField(exist = false)
    private String majorNumber;
    @TableField(exist = false)
    private String majorName;
}