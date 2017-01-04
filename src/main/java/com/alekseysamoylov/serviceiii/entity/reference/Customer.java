package com.alekseysamoylov.serviceiii.entity.reference;

import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
import com.alekseysamoylov.serviceiii.entity.CachableEntity;
import com.alekseysamoylov.serviceiii.entity.security.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Сущность клиент
 */
@Getter
@Setter
@Entity
@Table
public class Customer extends AbstractSequenceIdEntity implements CachableEntity {


    public static final String CACHE_NAME = "customer";

    @Override
    public String[] getCacheNames() {
        return new String[]{CACHE_NAME};
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
    private User user;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private boolean active = true;

}
