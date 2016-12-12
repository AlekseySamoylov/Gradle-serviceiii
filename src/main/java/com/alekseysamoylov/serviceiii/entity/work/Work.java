package com.alekseysamoylov.serviceiii.entity.work;

import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
import com.alekseysamoylov.serviceiii.entity.CachableEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 * Работа / Услуга
 */
@Entity
@Table(name = "work")
@Getter
@Setter
@JsonIgnoreProperties({
        "cacheNames"
})
public class Work extends AbstractSequenceIdEntity implements Serializable, CachableEntity {

    @JsonDeserialize
    public static final String CACHE_NAME = "work";

    @Override
    public String[] getCacheNames() {
        return new String[]{CACHE_NAME};
    }

    @Column
    private String title;

    @Column
    private BigDecimal price;

    @Column
    private String details;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_group_id", nullable = false)
    private WorkGroup workGroup;

    @Override
    public String toString() {
        return "Work{" +
                "id=" + super.getId() +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", details='" + details + '\'' +
                '}';
    }


}
