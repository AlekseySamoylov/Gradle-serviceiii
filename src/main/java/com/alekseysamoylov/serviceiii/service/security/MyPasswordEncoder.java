package com.alekseysamoylov.serviceiii.service.security;

import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Сервис для генерации пароля
 */
@Service
public class MyPasswordEncoder {
    public String encodePassword(String pass) {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        return encoder.encode(pass);
    }

    public static void main(String[] args) {
        MyPasswordEncoder passwordEncoder = new MyPasswordEncoder();
        System.out.println(passwordEncoder.encodePassword("secret"));
    }

}
