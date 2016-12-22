package com.alekseysamoylov.serviceiii.service.security;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Created by alekseysamoylov on 12/22/16.
 */
public class MyPasswordEncoderTest {

    private String encodePasswordTemp(String pass) {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        return encoder.encode(pass);
    }

    private boolean matchPasswordTemp(String passDB, String pass) {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        return encoder.matches(pass, passDB);
    }

    public static void main(String[] args) {
        MyPasswordEncoderTest myPasswordEncoder = new MyPasswordEncoderTest();
        System.out.println(myPasswordEncoder.encodePasswordTemp("secret"));
        System.out.println(myPasswordEncoder.matchPasswordTemp("1f783811c5a9add1c1789b5af6e049ce242809612fc63472ee7f26d92a737934036cad9558590ccc", "secret"));
    }
}