package com.qxf.hiswww.dao;

import com.qxf.hiswww.domain.WCompany;

public interface WCompanyMapper {
    int deleteByPrimaryKey(String id);

    int insert(WCompany record);

    int insertSelective(WCompany record);

    WCompany selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WCompany record);

    int updateByPrimaryKeyWithBLOBs(WCompany record);

    int updateByPrimaryKey(WCompany record);
}