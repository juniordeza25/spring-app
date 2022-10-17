package com.example.springapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import java.math.BigDecimal;

//Importacion de manera estatica, solo por orden
import static javax.persistence.GenerationType.SEQUENCE;

/*
* JsonIgnore: Se usa para que no se muestre en los resultados del cliente
*/

@Entity
@Table(name = "products")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Product {
    /*Para que no se creen los id de manera secuencial uniendo las creaciones en ambas tablas*/
    @Id @GeneratedValue(strategy = SEQUENCE, generator = "categories_id_seq")
    @SequenceGenerator(name = "categories_id_seq", sequenceName = "categories_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    /*Para hacer referencia al id de la categoria, solo se maneje internamente al crear un producto*/
    @JsonIgnore
    @Column(name = "category_id", nullable = false)
    private Short categoryId;
    @ManyToOne(optional = false)//referencia a que es de muchos a uno con la Entidad Category
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Category category;
    @JsonIgnore
    @Column(nullable = false)
    private Boolean deleted;
}
