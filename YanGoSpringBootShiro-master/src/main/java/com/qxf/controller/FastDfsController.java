package com.qxf.controller;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/9  1:24
 */

import com.baomidou.mybatisplus.plugins.Page;
import com.qxf.pojo.*;
import com.qxf.service.*;
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

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * fastdfs上传材料文件管理类
 */
@RestController
@RequestMapping("/materials")
public class FastDfsController extends BaseController{


    @Autowired
    FastDfsUserService fastDfsUserService;
    @Autowired
    FastDfsService fastDfsService;
    /**
     * 查询所有文件
     */
    @GetMapping("/list")
    public Object getListByPage(Integer startPage,Integer pageSize,String name){
        Page<FastDfs> page = new Page<>(startPage,pageSize);
        List<FastDfs> list = fastDfsService.getFastDfsByPage(page,name);
        return ResultUtil.result(EnumCode.OK.getValue(),"请求成功",list,page.getTotal());
    }


    /**
     * 文件上传/materials/dowload
     */
    @PostMapping("/upload")
    public Object upload(MultipartFile[] myFile ,@RequestParam("id") String id) throws IOException {
//        System.out.println(myFile.getBytes());//获取文件对应字节数组
//        System.out.println(myFile.getInputStream());//获取文件对应的输入流
//        System.out.println(myFile.getContentType());//获取文件类型
//        System.out.println(myFile.getName());//获取表单元素名
//        System.out.println(myFile.getOriginalFilename());//获取文件名
//        System.out.println(myFile.getSize());//获取文件大小
//        System.out.println(myFile.isEmpty());//判断文件是否为空 如果没有上传文件或文件大小为0 这个值都是true
        User userMess = userService.selectById(id);
        if (myFile != null && myFile.length > 0) {
            for (int i = 0; i < myFile.length; i++) {
                //获取文件对应的字节数组
                byte[] buffFile = myFile[i].getBytes();
                //获取文件名
                String fileName = myFile[i].getOriginalFilename();
                //获取文件大小
                Long fileSize = myFile[i].getSize();
                //获取文件类型
                String fileType = myFile[i].getContentType();
                //可能会出现问题因为有些文件可能没有扩展名，因此必要时需要做逻辑控制
                String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
                try {
                    String[] uploadArray = FastDFSUploadUtils.fileUpload(buffFile, fileExtName);
                    if (uploadArray != null && uploadArray.length == 2) {
                        //获取文件信息插入
                        FastDfs fastDfs = new FastDfs();
                        fastDfs.setId(UUID.randomUUID().toString().replace("-", ""));
                        fastDfs.setFileName(fileName);
                        String str = "http://47.97.105.41/" + uploadArray[0]+ "/" + uploadArray[1];
                        fastDfs.setFilePath(str);
                        fastDfs.setDownCount(0);
                        fastDfs.setUploadTime(new Date());
                        String userName = userMess.getUsername();
                        fastDfs.setUploader(userName);
                        fastDfs.setSize(String.valueOf(fileSize));
                        boolean insert = fastDfsService.insert(fastDfs);
                        //插入t_fastdfs_user
                        FastDfsUser user = new FastDfsUser();
                        user.setId(UUID.randomUUID().toString().replace("-", ""));
                        user.setUserId(id);
                        user.setFastdfsId(fastDfs.getId());
                        boolean insert1 = fastDfsUserService.insert(user);
                        if (insert && insert1) {
                            return ResultUtil.result(EnumCode.OK.getValue(), "发送成功");
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                    return ResultUtil.result(EnumCode.BAD_UPLOAD.getValue(), "发送失败");
                }
            }
        }

        return ResultUtil.result(EnumCode.BAD_UPLOAD.getValue(), "发送失败");
    }



    /**
     * 文件下载/materials/dowload
     */
    @GetMapping("/dowload")
    public Object dowload(@RequestParam("id")String id){
        FastDfs fastDfs = fastDfsService.selectById(id);
        fastDfs.setLastdownTime(new Date());
        fastDfs.setDownCount(fastDfs.getDownCount()+1);
        fastDfsService.updateById(fastDfs);
        String userId = super.getUserId();
        FastDfsUser fastDfsUser = new FastDfsUser();
        fastDfsUser.setUserId(userId);
        fastDfsUser.setFastdfsId(fastDfs.getId());
        boolean insert = fastDfsUserService.insert(fastDfsUser);
        if(insert){
            return ResultUtil.result(EnumCode.OK.getValue(), "请求成功",fastDfs.getFilePath());
        }
        return ResultUtil.result(EnumCode.BAD_DOWN.getValue(), "下载失败");
    }

    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    SecretaryService secretaryService;
    @Autowired
    StudentService studentService;
    /**
     * 上传头像
     */
    @RequestMapping("/userUpload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("pic") MultipartFile myFile,
                                   @RequestParam("id") String userId ,@RequestParam("roleId")String roleId)   {
       try {
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

           String[] uploadArray= FastDFSUploadUtils.fileUpload(buffFile,fileExtName);

           if (uploadArray!=null&&uploadArray.length==2){
               String str = "http://47.97.105.41/"+uploadArray[0] +"/"+ uploadArray[1];
               /**判断角色，插入不同的表
                * 2.导师
                * 3.学生
                * 4.教学秘书
                */
               User user = userService.selectById(userId);
               String userName = user.getUsername();
               Map<String,Object> map = new HashMap<>();
               map.put("name",userName);
               if(roleId.equals("2")){
                   List<Teacher> teachers = teacherService.selectByMap(map);
                   Teacher teacher = teachers.get(0);
                   teacher.setPhotoUrl(str);
                   teacherService.updateById(teacher);
               }if(roleId.equals("3")){
                   List<Student> students = studentService.selectByMap(map);
                   Student student = students.get(0);
                   student.setPhotoUrl(str);
                   studentService.updateById(student);
               }
               user.setPhotoUrl(str);
               userService.updateById(user);
               return ResultUtil.result(EnumCode.OK.getValue(), "上传成功");
           }
       }catch (Exception e){
           e.printStackTrace();
           return ResultUtil.result(EnumCode.BAD_UPLOAD.getValue(), "上传失败");
       }
        return ResultUtil.result(EnumCode.BAD_UPLOAD.getValue(), "上传失败");
    }

    /**
     * 删除
     * @param fastDfs
     * @return
     */

    @PostMapping("/delete")
    public Object deleteMaterials(FastDfs fastDfs){
        String[] ids = fastDfs.getIds();
        if (null == ids || ids.length == 0) {
            return ResultUtil.result(EnumCode.BAD_REQUEST.getValue(), EnumCode.BAD_REQUEST.getText());
        }
        return fastDfsService.deleteMaterials(ids,super.getUserId(),super.getUserName());
    }
    /**
     * 查询所有被删除的文件
     */
    @Autowired
    FastDfsDelService fastDfsDelService;
    @GetMapping("/delList")
    public Object getDelListByPage(Integer startPage,Integer pageSize,String name){
        Page<FastDfsDel> page = new Page<>(startPage,pageSize);

        List<FastDfsDel> list = fastDfsDelService.getFastDfsDelByPage(page,name);
        return ResultUtil.result(EnumCode.OK.getValue(),"请求成功",list,page.getTotal());
    }






}
