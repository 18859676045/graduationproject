package com.qxf.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("t_fastdfs_user")
public class FastDfsUser {
    private String id;

    @TableField("user_id")
    private String userId;
    @TableField("fastdfs_id")
    private String fastdfsId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFastdfsId() {
        return fastdfsId;
    }

    public void setFastdfsId(String fastdfsId) {
        this.fastdfsId = fastdfsId;
    }
}