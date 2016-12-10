package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.company.CompanyType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 * Возвращает карту с названием элемента перечисления и его строковым обозначением
 */
@Service
public class EnumDetaisServiceImpl implements EnumDetailsService {
    @Override
    public Map<String, String> getEnumDetails() {
        Map<String, String> enumMap = new HashMap<>();
        for (CompanyType companyType : CompanyType.values()) {
            enumMap.put(companyType.toString(), companyType.getName());
        }
        return enumMap;
    }
}
