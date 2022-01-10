package com.qxf.controller;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.plugins.Page;
import com.mysql.cj.xdevapi.JsonArray;
import com.qxf.hiswww.domain.TTeacher;
import com.qxf.pojo.Teacher;
import com.qxf.service.TeacherService;
import com.qxf.utils.EnumCode;
import com.qxf.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: WangWeiWen
 * @Date: 2021/11/24
 * @Description: com.qxf.controller
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/list")
    public Object getListByPage(Integer startPage,Integer pageSize,String name){
        Page<Teacher> page = new Page<>(startPage,pageSize);
        List<Teacher> list = teacherService.getListByPage(page,name);
        return ResultUtil.result(EnumCode.OK.getValue(),"请求成功",list,page.getTotal());
    }

    @PostMapping("/add")
    public Object addTeacher (Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    @GetMapping("/findAllTeacher")
    public Object findAllTeacher() {
        List<Teacher> allTeacher = teacherService.findAllTeacher();
        return ResultUtil.result(EnumCode.OK.getValue(),"请求成功",allTeacher);
    }
    @GetMapping("/findOneMessage")
    public Object teacherOneMessage(String id){

       TTeacher teacher = teacherService.findOneMessage(id);
       if (StringUtils.isEmpty(teacher)){
           return null;
       }
       return ResultUtil.result(EnumCode.OK.getValue(), "查询成功", JSONArray.toJSON(teacher));
    }


}
