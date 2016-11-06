package com.alekseysamoylov.serviceiii.entity;

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
@Table(name = "price_group")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "PriceGroup.findAllFetchLazy", query = "select pg from PriceGroup pg left join fetch pg.prices pr")
})
public class PriceGroup implements Serializable, CachableEntity {

    @JsonDeserialize
    public static final String CACHE_NAME = "priceGroup";

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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "priceGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Price> prices;

    @Override
    public String toString() {
        return "id " + id
                + " title " + title;
    }
}
