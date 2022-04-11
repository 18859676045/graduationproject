package com.qxf.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qxf.pojo.PracticeRisk;

public interface PracticeRiskMapper extends BaseMapper<PracticeRisk> {
    int deleteByPrimaryKey(String id);

//    int insert(PracticeRisk record);

    int insertSelective(PracticeRisk record);

    PracticeRisk selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PracticeRisk record);

    int updateByPrimaryKey(PracticeRisk record);
}