package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.Price;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@Service
public class PriceServiceImpl implements PriceService {
    @Override
    public List<Price> findAll() {
        List<Price> prices = new ArrayList<>();
        prices.add(new Price("One"));
        prices.add(new Price("two"));
        prices.add(new Price("three"));
        prices.add(new Price("four"));

        return prices;
    }
}
