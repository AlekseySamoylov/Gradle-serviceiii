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
 */
@Entity
@Table(name = "work_group")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "WorkGroup.findAllFetchLazy", query = "select pg from WorkGroup pg left join fetch pg.works pr"),
        @NamedQuery(name = "WorkGroup.findAll", query = "select pg from WorkGroup pg")

})
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
    public String toString() {
        return "id " + id
                + " title " + title;
    }
}
