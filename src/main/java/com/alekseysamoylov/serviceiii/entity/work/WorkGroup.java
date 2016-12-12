package com.alekseysamoylov.serviceiii.entity.work;

import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
import com.alekseysamoylov.serviceiii.entity.CachableEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 * Группа работ / услуг
 */
@Entity
@Table(name = "work_group")
@Getter
@Setter
@JsonIgnoreProperties({
        "cacheNames"
})
public class WorkGroup extends AbstractSequenceIdEntity implements Serializable, CachableEntity {

    @JsonDeserialize
    public static final String CACHE_NAME = "workGroup";

    @Override
    public String[] getCacheNames() {
        return new String[]{CACHE_NAME};
    }

    @Column(name = "title")
    private String title;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Work> works;


    @Override
    public String toString() {
        return "id " + super.getId()
                + " title " + title;
    }
}
