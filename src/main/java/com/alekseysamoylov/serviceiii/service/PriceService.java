package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.Price;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public interface PriceService {
    List<Price> findAll();
}
