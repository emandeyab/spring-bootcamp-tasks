package com.spring.vehicleSystem.service;

import com.spring.vehicleSystem.model.Vehicle;

import java.util.List;

public interface VehicleService {
    void save(Vehicle vehicle);
    void delete(int id);
    void update(Vehicle vehicle);
    Vehicle searchById(int id);
    List<Vehicle> getAll();
}
