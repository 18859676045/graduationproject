package com.qxf.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/9  23:40
 */
@Data
public class EditUserVo implements Serializable {

    private User user;
    private Teacher teacher;
    private Student student;
    private Role role;
    private Secretary secretary;
    //老师职称
    private String teacherPost;
    private String title2;
    //学生
    private Institute institute;
    private Major major;
    private Clazz clazz;
}
