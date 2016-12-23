package com.alekseysamoylov.serviceiii.entity;

import javax.persistence.MappedSuperclass;

/**
 * Created by alekseysamoylov on 12/23/16.
 */
@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractSequenceIdEntity {


    private String name;
}
