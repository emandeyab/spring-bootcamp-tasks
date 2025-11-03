package com.spring.hibernate.hql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private double price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    private String manufacturer;

    @Column(name = "production_date")
    @Temporal(TemporalType.DATE)
    private Date productionDate;

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name
                + ", description=" + description + ", price=" + price
                + ", stockQuantity=" + stockQuantity + ", manufacturer=" + manufacturer
                + ", productionDate=" + productionDate;
    }
}
