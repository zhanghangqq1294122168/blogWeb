package cn.zh.blog.controller;

import cn.zh.blog.entity.UpFile;
import cn.zh.blog.entity.Yml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private Yml yml;


    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String url;
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            assert fileName != null;
            String newFileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
            File dest = new File(yml.getUpload() + newFileName);
            UpFile upFile = new UpFile();
            upFile.setFileName(fileName);
            url= dest.getAbsolutePath();
            upFile.setUrl(url);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return url;
        }
        return "file is null";
    }

}
