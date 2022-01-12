package com.qxf.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.sun.org.apache.xml.internal.serializer.Serializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_fastdfs")
public class FastDfs implements Serializable {

    private String id;
    @TableField("file_name")
    private String fileName;
    @TableField("file_path")
    private String filePath;
    @TableField("down_count")
    private Integer downCount;
    @TableField("upload_time")
    private Date uploadTime;
    @TableField("uploader")
    private String uploader;
    @TableField("lastdown_time")
    private Date lastdownTime;

    private String size;
    @TableField(exist = false)
    private String[] ids;

}