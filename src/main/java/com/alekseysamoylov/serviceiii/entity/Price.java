package com.alekseysamoylov.serviceiii.entity;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@Getter
@Setter
public class Price {
    private String name;

    public Price() {
    }

    public Price(String name) {
        this.name = name;
    }
}
