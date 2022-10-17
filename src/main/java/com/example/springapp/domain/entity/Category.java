package com.example.springapp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "categories")
//Con Lombok
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Category {
    @Id @GeneratedValue(strategy = SEQUENCE, generator = "products_id_seq")
    @SequenceGenerator(name = "products_id_seq", sequenceName = "products_id_seq", initialValue = 1, allocationSize = 1)
    private Short id;
    @Column(nullable = false, length = 50)
    private String name;

}
