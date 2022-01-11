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

    private String email;

    @TableField("photo_url")
    private String photoUrl;

    private String phone;

    @TableField("major_id")
    private String majorId;

    private String username;
}
