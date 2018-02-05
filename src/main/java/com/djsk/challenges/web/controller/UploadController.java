package com.djsk.challenges.web.controller;

import com.djsk.challenges.business.service.IDifferentOperationService;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

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

    @GetMapping("/logger_test")
    public void getLog(){
        logger.warn("This is warning from: " + this.getClass());
        logger.info("You can log something");
        logger.warn("You can log something");
        logger.debug("You can log something");
        logger.error("You can log something");
    }
}
