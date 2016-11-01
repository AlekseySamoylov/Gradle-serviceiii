package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.Price;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public interface PriceRepository {
    public List<Price> findAll();
}
