package com.alekseysamoylov.serviceiii.entity.bonus;

import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Сущность Бонусные баллы пользователя
 */
@Entity
@Table
@Getter
@Setter
@ToString
public class Bonus extends AbstractSequenceIdEntity {

    @Column
    private BigDecimal value;

    @Temporal(TemporalType.DATE)
    private Date date;

}
