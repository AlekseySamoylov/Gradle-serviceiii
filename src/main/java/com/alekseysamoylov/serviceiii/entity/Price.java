package com.alekseysamoylov.serviceiii.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@Entity
@Table(name = "price")
@Getter
@Setter
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String value;

    @Column
    private String details;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_group_id", nullable = false)
    private PriceGroup priceGroup;

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", details='" + details + '\'' +
                ", priceGroup=" + priceGroup.getTitle() +
                '}';
    }
}
