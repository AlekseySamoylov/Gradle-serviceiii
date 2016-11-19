package com.alekseysamoylov.serviceiii.controller.file;

import com.alekseysamoylov.serviceiii.constant.RestPathConstants;
import com.alekseysamoylov.serviceiii.constant.SuffixConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by alekseysamoylov on 11/19/16.
 * <p>
 * Контроллер для работы с файлами
 */
@RestController
@RequestMapping("/files")
public class FilesRestController {

    private ServletContext servletContext;

    @Autowired
    public FilesRestController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @CrossOrigin
    @RequestMapping(value = "/staticImages/{imageName}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> showImage(@PathVariable String imageName) throws IOException {
        String pathToImage = RestPathConstants.IMAGES_PATH + imageName + SuffixConstants.PNG_SUFFIX;
        return getResponseEntityImage(pathToImage);
    }

    /**
     * Возвращает объект изображения для отправки клиенту
     *
     * @param pathToImage путь к изображению
     * @return объект изображения для отправки клиенту
     */
    private ResponseEntity<byte[]> getResponseEntityImage(String pathToImage) {
        ResponseEntity<byte[]> imageEntity;
        try {
            File imgPath = new File(servletContext.getRealPath(pathToImage));
            byte[] image = Files.readAllBytes(imgPath.toPath());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentLength(image.length);
            imageEntity = new ResponseEntity<>(image, headers, HttpStatus.OK);
        } catch (IOException ex) {
            throw new IllegalArgumentException();
        }
        return imageEntity;
    }
}
