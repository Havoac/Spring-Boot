package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    // public final String UPLOAD_DIR =
    // "C:\\Users\\shiva\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\SpringBoot\\bootrestbook\\src\\main\\resources\\static\\image";

    // works when constructor gets called, so create one
    public final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {

    }

    public boolean UploadFile(MultipartFile file) {
        boolean fileUploaded = false;

        try {
            // read the file
            InputStream is = file.getInputStream();
            byte data[] = new byte[is.available()];
            is.read(data);

            // write
            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator + file.getOriginalFilename());
            fos.write(data);
            fos.flush();
            fos.close();

            fileUploaded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileUploaded;
    }
}
