package com.alekseysamoylov.serviceiii.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by alekseysamoylov on 11/20/16.
 * Тестовый класс для загрузки файла
 */
@Getter
@Setter
public class FileUpload {

    private MultipartFile file;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileUpload that = (FileUpload) o;

        return file != null ? file.equals(that.file) : that.file == null;

    }

    @Override
    public int hashCode() {
        return file != null ? file.hashCode() : 0;
    }

    @Override
    public String toString() {
        if (file == null) {
            return "File exists";
        } else {
            return "File doesn't exist";
        }

    }
}
