package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.PriceGroup;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public interface PriceGroupService {
    List<PriceGroup> findAllFetchLazy();
}
