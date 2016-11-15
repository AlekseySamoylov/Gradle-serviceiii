package com.alekseysamoylov.serviceiii.entity;

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
public class WorkGroup implements Serializable, CachableEntity {

    @JsonDeserialize
    public static final String CACHE_NAME = "workGroup";

    @Override
    public String[] getCacheNames() {
        return new String[]{CACHE_NAME};
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Work> works;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkGroup workGroup = (WorkGroup) o;

        if (id != null ? !id.equals(workGroup.id) : workGroup.id != null) return false;
        if (title != null ? !title.equals(workGroup.title) : workGroup.title != null) return false;
        return works != null ? works.equals(workGroup.works) : workGroup.works == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 34 * result + (title != null ? title.hashCode() : 0);
        result = 34 * result + (works != null ? works.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "id " + id
                + " title " + title;
    }
}
