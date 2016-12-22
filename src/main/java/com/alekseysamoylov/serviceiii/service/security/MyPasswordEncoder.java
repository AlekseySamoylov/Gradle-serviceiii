package com.alekseysamoylov.serviceiii.service.security;

/**
 * Сервис для работы с паролем
 */
public interface MyPasswordEncoder {

    String encodePassword(String pass);

    boolean matchPassword(CharSequence rawPassword, String encodedPassword);
}
