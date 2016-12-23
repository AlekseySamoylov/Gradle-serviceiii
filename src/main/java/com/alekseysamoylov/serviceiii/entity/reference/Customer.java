package com.alekseysamoylov.serviceiii.entity.reference;

import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
import com.alekseysamoylov.serviceiii.entity.security.User;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Сущность клиент
 */
@Entity
@Table
public class Customer extends AbstractSequenceIdEntity {

    private User user;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private boolean active = true;

}
