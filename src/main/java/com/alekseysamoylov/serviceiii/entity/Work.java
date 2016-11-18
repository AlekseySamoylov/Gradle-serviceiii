package com.alekseysamoylov.serviceiii.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 * Работа / Услуга
 */
@Entity
@Table(name = "work")
@Getter
@Setter
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Work work = (Work) o;

        if (id != null ? !id.equals(work.id) : work.id != null) return false;
        if (title != null ? !title.equals(work.title) : work.title != null) return false;
        if (price != null ? !price.equals(work.price) : work.price != null) return false;
        if (details != null ? !details.equals(work.details) : work.details != null) return false;
        return workGroup != null ? workGroup.equals(work.workGroup) : work.workGroup == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (workGroup != null ? workGroup.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
