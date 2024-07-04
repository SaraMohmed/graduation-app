package com.panel.LRapp.Service;

import com.panel.LRapp.Entity.ImageData;
import com.panel.LRapp.Repo.StorageRepository;
import com.panel.LRapp.utill.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    public ImageData uploadImage(MultipartFile file) throws IOException {

//        ImageData imageData = repository.save(ImageData.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .imageData(ImageUtils.compressImage(file.getBytes())).build());

        ImageData imageData = ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build();
//        if (imageData != null) {
//            return "file uploaded successfully : " + file.getOriginalFilename();
//        }
        return imageData;
    }
}
