package com.djsk.challenges.business.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IDifferentOperationService {
    ResponseEntity<com.djsk.challenges.persistence.pojo.FileInfo> uploadFile(MultipartFile file);
}
