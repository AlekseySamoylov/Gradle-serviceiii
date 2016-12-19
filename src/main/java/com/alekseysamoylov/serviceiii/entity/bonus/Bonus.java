package com.alekseysamoylov.serviceiii.entity.bonus;

import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
import com.alekseysamoylov.serviceiii.entity.security.User;
import lombok.Getter;
import lombok.Setter;

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
public class Bonus extends AbstractSequenceIdEntity {

    @Column
    private BigDecimal value;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Bonus{" +
                "value=" + value +
                ", date=" + date +
                '}';
    }
}
