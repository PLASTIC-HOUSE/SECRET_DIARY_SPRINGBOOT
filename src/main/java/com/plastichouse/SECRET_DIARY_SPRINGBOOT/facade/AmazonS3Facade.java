package com.plastichouse.SECRET_DIARY_SPRINGBOOT.facade;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class AmazonS3Facade {

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Value("${aws.s3.base-url}")
    private String baseImageUrl;

    private final AmazonS3 amazonS3;

    public String uploadImage(MultipartFile file) {
        String uploadImagePath = baseImageUrl + UUID.randomUUID() + ".jpg";

        try {
            amazonS3.putObject(new PutObjectRequest(
                    bucketName,
                    uploadImagePath,
                    file.getInputStream(),
                    null
            ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return uploadImagePath;
    }

}