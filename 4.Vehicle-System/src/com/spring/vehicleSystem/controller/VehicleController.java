package com.spring.vehicleSystem.controller;

import com.spring.vehicleSystem.model.Vehicle;
import com.spring.vehicleSystem.service.VehicleService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleController {
    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    public void saveVehile(Vehicle vehicle) {
        vehicleService.save(vehicle);
    }

    public void deleteVhicle(int id) {
        vehicleService.delete(id);
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicleService.update(vehicle);
    }

    public Vehicle searchById(int id) {
        return vehicleService.searchById(id);
    }

    public List<Vehicle> getALL(){
        return vehicleService.getAll();
    }
}
