package com.alekseysamoylov.serviceiii.entity.reference;

import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
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
public class Customer extends AbstractSequenceIdEntity {

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee")
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
