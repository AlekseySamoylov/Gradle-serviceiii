package com.alekseysamoylov.serviceiii.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Абстрактный базовый класс для сущностей, которым необходимо иметь собственный
 * Sequence генератор для поля ID.
 */
@ToString
@MappedSuperclass
public abstract class AbstractSequenceIdEntity {


    @Id
    @Getter
    @Setter
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractSequenceIdEntity that = (AbstractSequenceIdEntity) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
