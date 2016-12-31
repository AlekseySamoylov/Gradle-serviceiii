package com.alekseysamoylov.serviceiii.entity.bonus;

import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
import com.alekseysamoylov.serviceiii.entity.CachableEntity;
import com.alekseysamoylov.serviceiii.entity.security.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Сущность Бонусные баллы пользователя
 */
@Entity
@Table
@Getter
@Setter
public class Bonus extends AbstractSequenceIdEntity implements Serializable, CachableEntity {

    public static final String CACHE_NAME = "bonus";

    @Override
    public String[] getCacheNames() {
        return new String[]{CACHE_NAME};
    }


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
