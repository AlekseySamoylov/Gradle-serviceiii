package com.alekseysamoylov.serviceiii.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@Entity
@Table(name = "test_table")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "TestClass.findAll", query = "select t from TestClass t")
})
public class TestClass implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "company_type", columnDefinition = "company_type")
    private CompanyType companyType;

    @Override
    public String toString() {
        return "TestClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyType=" + companyType +
                '}';
    }
}
