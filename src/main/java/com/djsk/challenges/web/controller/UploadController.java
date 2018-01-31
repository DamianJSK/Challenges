package com.djsk.challenges.web.controller;

import com.djsk.challenges.business.service.IDifferentOperationService;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    IDifferentOperationService differentOperationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/jpg_upload")
    public void create(@RequestParam("file") MultipartFile file) throws IOException, FileUploadException {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if(!extension.equalsIgnoreCase("jpg")){
            throw new FileUploadException("Invalid file format - must be jpg");
        }
        differentOperationService.uploadFile(file);
    }
}
