package com.qxf.controller;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/9  1:24
 */

import com.qxf.pojo.FastDfs;
import com.qxf.pojo.FastDfsUser;
import com.qxf.service.FastDfsService;
import com.qxf.service.FastDfsUserService;
import com.qxf.utils.EnumCode;
import com.qxf.utils.FastDFSUploadUtils;
import com.qxf.utils.ResultUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * fastdfs上传材料文件管理类
 */
@RestController
@RequestMapping("/materials")
public class UploadController extends BaseController{


    @Autowired
    FastDfsUserService fastDfsUserService;
    @Autowired
    FastDfsService fastDfsService;
    /**
     * 文件上传/materials/dowload
     */
    @PostMapping("/upload")
    public Object upload(MultipartFile myFile) throws IOException {
//        System.out.println(myFile.getBytes());//获取文件对应字节数组
//        System.out.println(myFile.getInputStream());//获取文件对应的输入流
//        System.out.println(myFile.getContentType());//获取文件类型
//        System.out.println(myFile.getName());//获取表单元素名
//        System.out.println(myFile.getOriginalFilename());//获取文件名
//        System.out.println(myFile.getSize());//获取文件大小
//        System.out.println(myFile.isEmpty());//判断文件是否为空 如果没有上传文件或文件大小为0 这个值都是true
        //获取文件对应的字节数组
        byte[] buffFile=myFile.getBytes();
        //获取文件名
        String fileName=myFile.getOriginalFilename();
        //获取文件大小
        Long fileSize=myFile.getSize();
        //获取文件类型
        String fileType=myFile.getContentType();
        //可能会出现问题因为有些文件可能没有扩展名，因此必要时需要做逻辑控制
        String fileExtName=fileName.substring(fileName.lastIndexOf(".")+1);
        try {
        String[] uploadArray= FastDFSUploadUtils.fileUpload(buffFile,fileExtName);
        if (uploadArray!=null&&uploadArray.length==2){
            //获取文件信息插入
            FastDfs fastDfs = new FastDfs();
            fastDfs.setId(UUID.randomUUID().toString().replace("-",""));
            fastDfs.setFileName(fileName);
            String str = "http://47.97.105.41/"+uploadArray[0] + uploadArray[1];
            fastDfs.setFilePath(str);
            fastDfs.setDownCount(0);
            fastDfs.setUploadTime(new Date());
            String userName = super.getUserName();
            fastDfs.setUploader(userName);
            fastDfs.setSize(fileSize.toString());
            boolean insert = fastDfsService.insert(fastDfs);
            //插入t_fastdfs_user
            FastDfsUser user = new FastDfsUser();
            user.setId(UUID.randomUUID().toString().replace("-",""));
            user.setUserId(super.getUserId());
            user.setFastdfsId(fastDfs.getId());
            boolean insert1 = fastDfsUserService.insert(user);
            if (insert && insert1){
                return ResultUtil.result(EnumCode.OK.getValue(), "发送成功");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
            return ResultUtil.result(EnumCode.BAD_UPLOAD.getValue(), "发送失败");
    }

        return ResultUtil.result(EnumCode.BAD_UPLOAD.getValue(), "发送失败");
    }



    /**
     * 文件下载/materials/dowload
     */
    @GetMapping("/dowload")
    public ResponseEntity<byte[]> dowload(@RequestParam("id")String id){
        FastDfs fastDfs = fastDfsService.selectById(id);
        fastDfs.setLastdownTime(new Date());
        fastDfs.setDownCount(fastDfs.getDownCount()+1);
        fastDfsService.updateById(fastDfs);
//        FastDFSUploadUtils.fileUpload()
//        //根据债权id获取 债权对象
//        CreditorFile file = creditorInfoService.findFileById(id);
//        String remoteFilename = file.getRemoteFilename();
//        String extName = remoteFilename.substring(remoteFilename.indexOf("."));
//
//        byte[] bytes = FastDFSUploadUtils.fileDownload(file.getGroupName(), remoteFilename);
//
//        HttpHeaders headers=new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//流类型
//        headers.setContentDispositionFormData("attachment",System.currentTimeMillis()+extName);
//
//        ResponseEntity<byte[]> responseEntity=new ResponseEntity<byte[]>(bytes,headers, HttpStatus.OK);

//        return responseEntity;

        return null;
    }






}
