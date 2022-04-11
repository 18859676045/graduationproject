package com.qxf.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("t_practice_risk")
@Data
public class PracticeRisk implements Serializable {
    private String id;

    @TableField("practice_way")
    private String practiceWay;

    private String risk;

    private String healthy;

}