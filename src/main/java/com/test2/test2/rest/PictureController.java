package com.test2.test2.rest;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
@RequestMapping("/picture")
public class PictureController {

    @CrossOrigin(origins = "localhost:3000")
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public String uploadFile(@RequestParam MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        File newFile = new File("test.png");
        try {
            file.transferTo(newFile);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "ok";
    }
}
