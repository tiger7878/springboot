package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传
 * @author: monkey
 * @date: 2018/9/5 21:44
 */
@Controller
public class UploadController {

    public static final Logger LOGGER= LoggerFactory.getLogger(UploadController.class);

    @RequestMapping("/toUpload")
    public String toUpload(){
        return "upload";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("roncooFile") MultipartFile file){

        if (file.isEmpty()){
            return "file is empty";
        }

        //获取原始文件名
        String fileName=file.getOriginalFilename();
        LOGGER.info("上传文件名为："+fileName);

        //获取文件后缀
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
        LOGGER.info("文件后缀："+suffixName);

        //文件上传路径
        String filePath="F:/JAVA/upload/";

        //文件重命名
        fileName= UUID.randomUUID()+suffixName;

        //保存的文件
        File dest=new File(filePath+fileName);

        //检查目录是否存在，如果不存在就创建
        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fail";
    }

}
