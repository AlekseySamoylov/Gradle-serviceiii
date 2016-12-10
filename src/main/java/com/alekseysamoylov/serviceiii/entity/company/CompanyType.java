package com.alekseysamoylov.serviceiii.entity.company;

import com.alekseysamoylov.serviceiii.entity.EnumMessageSource;
import com.alekseysamoylov.serviceiii.util.CustomIntegerEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Тип организации
 */
@Getter
@AllArgsConstructor
public enum CompanyType implements CustomIntegerEnum {

    CAR_SERVICE(0),

    TIRE_SERVICE(1),

    CAR_WASH(2);

    private int id;

    public String getName() {
        return EnumMessageSource.getName(this);
    }
}
