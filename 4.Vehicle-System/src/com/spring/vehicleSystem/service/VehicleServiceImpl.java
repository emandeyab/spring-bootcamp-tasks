package com.spring.vehicleSystem.service;

import com.spring.vehicleSystem.dao.VehicleDAO;
import com.spring.vehicleSystem.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleServiceImpl implements VehicleService{
    private VehicleDAO vehicleDAO;

    @Autowired
    public VehicleServiceImpl(VehicleDAO vehicleDAO){
        this.vehicleDAO = vehicleDAO;
    }
    @Override
    public void save(Vehicle vehicle) {
        vehicleDAO.save(vehicle);
    }

    @Override
    public void delete(int id) {
        vehicleDAO.delete(id);
    }

    @Override
    public void update(Vehicle vehicle) {
        vehicleDAO.update(vehicle);
    }

    @Override
    public Vehicle searchById(int id) {
        return vehicleDAO.searchById(id);
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleDAO.getAll();
    }
}
