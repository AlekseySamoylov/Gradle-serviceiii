package com.alekseysamoylov.serviceiii.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Реализация {@link MyPasswordEncoder}
 */
@Service
public class MyPasswordEncoderImpl implements MyPasswordEncoder {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MyPasswordEncoderImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encodePassword(String pass) {
        return passwordEncoder.encode(pass);
    }

    public boolean matchPassword(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }


}
