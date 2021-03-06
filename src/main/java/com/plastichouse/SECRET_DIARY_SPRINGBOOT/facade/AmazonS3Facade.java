package com.plastichouse.SECRET_DIARY_SPRINGBOOT.facade;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class AmazonS3Facade {

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Value("${aws.s3.base-url}")
    private String baseImageUrl;

    private final AmazonS3 amazonS3;

    public String uploadImage(File file) throws IOException {
        String uploadImagePath = UUID.randomUUID() + ".jpg";
        ObjectMetadata md = new ObjectMetadata();
        byte[] bytes = Files.readAllBytes(file.toPath());

        md.setContentType("image/jpeg");
        md.setContentLength(bytes.length);

        try {
            amazonS3.putObject(new PutObjectRequest(
                    bucketName,
                    uploadImagePath,
                    new FileInputStream(file),
                    md
            ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return baseImageUrl + uploadImagePath;
    }

}
