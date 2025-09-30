package com.spring.vehicleSystem.model;

import com.spring.vehicleSystem.dao.DatabaseOperations;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Setter
@Getter
public class Car implements Vehicle{
    private DatabaseOperations databaseOperations;
    private int id;
    private String brand;
    private String type;

    public Car(int id, String brand, String type) {
        this.id = id;
        this.brand = brand;
        this.type = type;
    }

    @Autowired
    public Car(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

}
