package com.restapi.fileupload.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file")// file is the reference variable
                         MultipartFile file) throws IOException // this is use to save the file in file variable
    {


        file.transferTo(
                new File(
                        "C:\\Users\\Sanket\\OneDrive\\Desktop\\java\\Course\\Anuj_Kumar\\fileupload\\uploads\\"// the folder name where the file is save
                       + file.getOriginalFilename()
                )// cope file to your projet
        );



        return  "file-name="+ file.getOriginalFilename()
               + " Size =" +file.getSize();// it return the file original name and size in bytes
    }




    @GetMapping("/student")
    public String getStudent() {
        return "Student Data";
    }

    @PostMapping("/student")
    public String saveStudent() {
        return "Student Saved";
    }


}
