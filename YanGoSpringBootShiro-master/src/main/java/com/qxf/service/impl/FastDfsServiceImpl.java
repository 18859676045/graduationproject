package com.qxf.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qxf.mapper.FastDfsMapper;
import com.qxf.pojo.*;
import com.qxf.service.FastDfsDelService;
import com.qxf.service.FastDfsService;
import com.qxf.utils.EnumCode;
import com.qxf.utils.FastDFSUploadUtils;
import com.qxf.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/11  1:15
 */
@Service
public class FastDfsServiceImpl extends ServiceImpl<FastDfsMapper, FastDfs> implements FastDfsService {
    @Override
    public List<FastDfs> getFastDfsByPage(Page<FastDfs> page, String name) {
        return super.baseMapper.getFastDfsByPage(page,name);
    }

    @Autowired
    FastDfsDelService fastDfsDelService;

    @Transactional
    @Override
    public Object deleteMaterials(String[] ids, String userId, String userName) {
        for (int i = 0; i < ids.length; i++) {
            /**
             *  服务器删除文件
             */
            //根据id查询删除的文件信息
            FastDfs fastDfs = baseMapper.selectByPrimaryKey(ids[i]);
            //插入删除表
            FastDfsDel fastDfsDel = new FastDfsDel();
            fastDfsDel.setDelUserId(userId);
            fastDfsDel.setDelUserName(userName);
            fastDfsDel.setDelTime(new Date());
            fastDfsDel.setDelFileName(fastDfs.getFileName());
            fastDfsDel.setDelFileUploader(fastDfs.getUploader());
            fastDfsDel.setDelFileSize(fastDfs.getSize());
            fastDfsDel.setDelFileDowncount(String.valueOf(fastDfs.getDownCount()));
            /**
             * 插入删除表
             */
            fastDfsDelService.insert(fastDfsDel);
//            FastDFSUploadUtils,截取组和名称
            String filePath = fastDfs.getFilePath();
            String group = filePath.substring(20, 26);
            String remote_fileName = filePath.substring(27);
            //删除
            FastDFSUploadUtils.fileDelete(group, remote_fileName);
            /**
             * 数据库删除文件
             */
            baseMapper.deleteByPrimaryKey(ids[i]);
        }
        return ResultUtil.result(EnumCode.OK.getValue(), "删除成功");
    }
}
