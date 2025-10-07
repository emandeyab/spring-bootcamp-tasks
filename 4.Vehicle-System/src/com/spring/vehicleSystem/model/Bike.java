package com.spring.vehicleSystem.model;

import com.spring.vehicleSystem.dao.DatabaseOperations;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bike implements Vehicle{
    @Autowired
    private DatabaseOperations databaseOperations;
    private int id;
    private String brand;
    private String type;

    public Bike(int id, String brand, String type) {
        this.id = id;
        this.brand = brand;
        this.type = type;
    }

}
