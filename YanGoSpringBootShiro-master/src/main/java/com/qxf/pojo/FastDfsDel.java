package com.qxf.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("t_fastdfs_del")
public class FastDfsDel {
    private String id;
    @TableField("del_user_id")
    private String delUserId;
    @TableField("del_user_name")
    private String delUserName;
    @TableField("del_time")
    private Date delTime;
    @TableField("del_file_name")
    private String delFileName;
    @TableField("del_file_uploader")
    private String delFileUploader;
    @TableField("del_file_size")
    private String delFileSize;
    @TableField("del_file_downcount")
    private String delFileDowncount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDelUserId() {
        return delUserId;
    }

    public void setDelUserId(String delUserId) {
        this.delUserId = delUserId;
    }

    public String getDelUserName() {
        return delUserName;
    }

    public void setDelUserName(String delUserName) {
        this.delUserName = delUserName;
    }

    public Date getDelTime() {
        return delTime;
    }

    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }

    public String getDelFileName() {
        return delFileName;
    }

    public void setDelFileName(String delFileName) {
        this.delFileName = delFileName;
    }

    public String getDelFileUploader() {
        return delFileUploader;
    }

    public void setDelFileUploader(String delFileUploader) {
        this.delFileUploader = delFileUploader;
    }

    public String getDelFileSize() {
        return delFileSize;
    }

    public void setDelFileSize(String delFileSize) {
        this.delFileSize = delFileSize;
    }

    public String getDelFileDowncount() {
        return delFileDowncount;
    }

    public void setDelFileDowncount(String delFileDowncount) {
        this.delFileDowncount = delFileDowncount;
    }
}