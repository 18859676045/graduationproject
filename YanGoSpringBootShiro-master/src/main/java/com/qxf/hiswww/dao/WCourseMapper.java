package com.qxf.hiswww.dao;

import com.qxf.hiswww.domain.WCourse;

public interface WCourseMapper {
    int deleteByPrimaryKey(String id);

    int insert(WCourse record);

    int insertSelective(WCourse record);

    WCourse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WCourse record);

    int updateByPrimaryKey(WCourse record);
}