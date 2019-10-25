package com.example.springbootfileupload;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {

    Map<String, Object> result=new HashMap<>();

    @RequestMapping("/uploadFile")
    public Map<String,Object> upload(@RequestParam("attach")MultipartFile file) throws IOException
    {
        //file info
        System.out.println("File name= " + file.getOriginalFilename());
        System.out.println("File type = " + file.getContentType());

        //Save to disk
        String filePath = "/home/rishabh.kohli/Desktop/";
        file.transferTo(new File(filePath + file.getOriginalFilename()));
        result.put("success",true);
        return result;

//        In case you have having issue with uploading big files. You can update the application.properties with the following statement
//
//        spring.http.multipart.maxFileSize=XXXMB
//        In case you want to try multiple files, you can update the configuration to
//
//        spring.http.multipart.maxRequestSize=XXXMB
    }
}
