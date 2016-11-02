package com.alekseysamoylov.serviceiii.entity;

import com.alekseysamoylov.serviceiii.util.CustomIntegerEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
//@JsonDeserialize(using = CustomEnumDeserializer.class)
public enum CompanyType implements CustomIntegerEnum {

    CAR_SERVICE(0),

    TIRE_SERVICE(1),

    CAR_WASH(2);

    private int id;

    public String getName() {
        return EnumMessageSource.getName(this);
    }
}
