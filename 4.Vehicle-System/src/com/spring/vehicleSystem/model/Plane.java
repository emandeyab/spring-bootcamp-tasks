package com.spring.vehicleSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.spring.vehicleSystem.dao.DatabaseOperations;

@Component
@Scope("prototype")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Plane implements Vehicle{
    private DatabaseOperations databaseOperations;
    private int id;
    private String brand;
    private String type;

    public Plane(int id, String brand, String type) {
        this.id = id;
        this.brand = brand;
        this.type = type;
    }

    @Autowired
    public void setDatabaseOperations(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }
}
