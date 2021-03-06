package com.qxf.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ Author 王炜雯
 * @ Date 2021/7/18  15:15
 */

public class FastDFSUploadUtils {

    public static void main(String[] args) {
//        fileUpload("C:/Users/Administrator/Desktop/新建文件夹/17级及19专升本毕业实习材料","excel");
//        http://47.97.105.41/ 20 , group1 6 ,
//        byte[] bytes = fileDownload("group2", "M00/00/00/CgAEBWHjyomATNptAABgUvgByVQ289.png");
//        System.out.println(bytes);
       String  str = "M00/00/00/CgAEBWHjyomATNptAABgUvgByVQ289.png";
        String substring = str.substring(10);
        System.out.println(substring);


    }

    private static TrackerServer trackerServer = null;
    private static StorageServer storageServer = null;
    //抽取获取StorageClient的方法
    public static StorageClient getStorageClient() throws IOException, MyException {
        //1.加载配置文件，默认去classpath下加载
        ClientGlobal.init("fdfs_client.conf");
        //2.创建TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        //3.创建TrackerServer对象
        trackerServer = trackerClient.getConnection();
        //4.创建StorageServler对象
        storageServer = trackerClient.getStoreStorage(trackerServer);
        //5.创建StorageClient对象，这个对象完成对文件的操作
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
        return storageClient;
    }
    //抽取关闭资源的方法
    public static void closeFastDFS() {
        if (storageServer != null) {
            try {
                storageServer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (trackerServer != null) {
            try {
                trackerServer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  上传文件的方法
     */
    public static String[] fileUpload(byte[] fileByte,String fileExt) {
        String [] uploadArray = null;

        try {
            StorageClient storageClient = getStorageClient();
            //6.上传文件  第一个参数：本地文件路径 第二个参数：上传文件的后缀 第三个参数：文件信息
             uploadArray = storageClient.upload_file(fileByte, fileExt, null);

            for (String str : uploadArray) {
                System.out.println(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           closeFastDFS();
        }
        return uploadArray;
    }
    /**
     * 下载文件方法
     */
    public static byte[] fileDownload(String localFilePath,String group,String remote_fileName){

        byte[] num=null;
        try {
            File file = new File(localFilePath);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            //1. 获取StorageClient对象
            StorageClient storageClient = getStorageClient();
            //2.下载文件 返回0表示成功，其它均表示失败
             num = storageClient.download_file(group, remote_fileName);
            bos.write(num);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }finally {
            closeFastDFS();
        }
        return null;
    }
    /**
     * 删除方法
     */
    public static int fileDelete(String group,String remote_fileName){
        //1. 获取StorageClient对象
        int num=1;
        try {
            //1. 获取StorageClient对象
            StorageClient storageClient = getStorageClient();
             num = storageClient.delete_file(group,remote_fileName);
            System.out.println(num);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }finally {
            closeFastDFS();
        }
      return num;
    }










}
