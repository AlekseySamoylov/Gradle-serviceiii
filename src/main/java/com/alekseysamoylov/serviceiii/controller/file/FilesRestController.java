package com.alekseysamoylov.serviceiii.controller.file;

import com.alekseysamoylov.serviceiii.constant.RestPathConstants;
import com.alekseysamoylov.serviceiii.constant.SuffixConstants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by alekseysamoylov on 11/19/16.
 *
 * Контроллер для работы с файлами
 */
@RestController
@RequestMapping("/files")
public class FilesRestController {

    private static final Logger logger = Logger.getLogger(FilesRestController.class);

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

    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFileHandler(@RequestParam("name") String name,
                                    @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
    }

    /**
     * Upload multiple file using Spring Controller
     */
    @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
    public String uploadMultipleFileHandler(@RequestParam("name") String[] names,
                                            @RequestParam("file") MultipartFile[] files) {

        if (files.length != names.length)
            return "Mandatory information missing";

        String message = "";
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = names[i];
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                message = message + "You successfully uploaded file=" + name
                        + " ";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        }
        return message;
    }

}
