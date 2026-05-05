package com.example.demoJava4.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {

    private final static String UPLOAD_IMAGE_DIRECTORY = "src/main/resources/static/images/" ;

    public static String save(MultipartFile file){

        try {
            Path uploadPath = Paths.get(UPLOAD_IMAGE_DIRECTORY);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String fullFilename = UUID.randomUUID()+ file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fullFilename);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            String s = "/images/" + fullFilename;
            return s;
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
}
