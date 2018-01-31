package com.djsk.challenges.business.service.impl;

import com.djsk.challenges.business.service.IDifferentOperationService;
import com.djsk.challenges.persistence.pojo.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@Service
public class DifferentOperationService implements IDifferentOperationService{

    @Autowired
    ServletContext context;

    @Override
    public ResponseEntity<FileInfo> uploadFile(MultipartFile file) {
        FileInfo fileInfo = new FileInfo();
        HttpHeaders headers = new HttpHeaders();
        if (!file.isEmpty()) {
            try {
                String originalFilename = file.getOriginalFilename();
                File destinationFile = new File(context.getRealPath("/WEB-INF/uploaded")+  File.separator + originalFilename);
                file.transferTo(destinationFile);
                fileInfo.setFileName(destinationFile.getPath());
                fileInfo.setFileSize(file.getSize());
                headers.add("File Uploaded Successfully - ", originalFilename);
                return new ResponseEntity<FileInfo>(fileInfo, headers, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
        }
    }
}
