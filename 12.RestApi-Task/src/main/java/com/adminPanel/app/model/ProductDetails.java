package com.adminPanel.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product_details")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Description is required")
    private String name;

    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be greater than 0")
    private double price;

    @Column(name = "expiration_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @NotNull(message = "Expiration date is required")
    private LocalDate expirationDate;

    @NotBlank(message = "Manufacturer is required")
    private String manufacturer;

    private boolean available;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
