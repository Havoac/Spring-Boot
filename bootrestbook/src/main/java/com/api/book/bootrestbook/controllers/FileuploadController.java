package com.api.book.bootrestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.bootrestbook.helper.FileUploadHelper;

@RestController
public class FileuploadController {
    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> UploadFile(@RequestParam("file") MultipartFile file) {

        try {
            if (file.isEmpty())
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain a file");

            boolean isFileUploaded = fileUploadHelper.UploadFile(file);

            if (isFileUploaded) {
                // ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath() =>
                // http://localhost:8198
                // The net url is => http://localhost:8198/image/FileName
                // the file will be saved in target/classes/com/static/image {This is the
                // dynamic path, since after deploying this is where the file gets access from}
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
                        .path(file.getOriginalFilename()).toUriString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong ! Try again");
    }
}
