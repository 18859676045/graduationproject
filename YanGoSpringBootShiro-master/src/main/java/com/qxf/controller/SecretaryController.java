package com.qxf.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.qxf.pojo.FastDfs;
import com.qxf.pojo.Institute;
import com.qxf.pojo.Secretary;
import com.qxf.pojo.Student;
import com.qxf.service.SecretaryService;
import com.qxf.utils.EnumCode;
import com.qxf.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/12  18:53
 */
@RestController
@RequestMapping("/secretary")
public class SecretaryController {

    @Autowired
    SecretaryService secretaryService;
    /**
     * 查询教秘列表
     */
    @GetMapping("/list")
    public Object getListByPage(Integer startPage,Integer pageSize,String name){
        Page<Secretary> page = new Page<>(startPage,pageSize);
        List<Secretary> list = secretaryService.getSecretaryByPage(page,name);
        return ResultUtil.result(EnumCode.OK.getValue(),"请求成功",list,page.getTotal());
    }

    /**
     * 添加教秘
     * @param
     * @return
     */
    @PostMapping("/add")
    public Object addSecretary(Secretary secretary){
        return secretaryService.insertSecretary(secretary);
    }

    /**
     * 删除教秘
     * @param secretary
     * @return
     */
    @PostMapping("/delete")
    public Object deleteStudent(Secretary secretary){
        String[] ids = secretary.getIds();
        if (null == ids || ids.length == 0) {
            return ResultUtil.result(EnumCode.BAD_REQUEST.getValue(), EnumCode.BAD_REQUEST.getText());
        }
        return secretaryService.deleteSecretary(ids);
    }

}
