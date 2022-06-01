package com.plastichouse.SECRET_DIARY_SPRINGBOOT.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Component
public class MergedImageFacade {

    private final AmazonS3Facade amazonS3Facade;
    private static final int FILE_SIZE = 5;
    private static final int MERGED_IMAGE_LENGTH = 600;
    private static final int IMAGE_WIDTH = 300;
    private static final int IMAGE_HEIGHT = 200;


    public String getMergedImagePath(List<MultipartFile> files) {
        BufferedImage[] bufferedImages = new BufferedImage[5];
        for (int i = 0; i < 5; i++) {
            try {
                bufferedImages[i] = ImageIO.read((File) files.get(i));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BufferedImage mergedImage = new BufferedImage(MERGED_IMAGE_LENGTH, MERGED_IMAGE_LENGTH, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics2D = mergedImage.createGraphics();
        graphics2D.setBackground(Color.BLACK);
        for (int i = 0, w = 0, h = 0; i < FILE_SIZE; i++) {
            if (i % 2 != 0) w = IMAGE_WIDTH;
            if (i > 0 && i % 2 == 0) h += IMAGE_HEIGHT;

            graphics2D.drawImage(bufferedImages[i], w, h, null);
        }

        return amazonS3Facade.uploadImage(mergedImage);
    }

}