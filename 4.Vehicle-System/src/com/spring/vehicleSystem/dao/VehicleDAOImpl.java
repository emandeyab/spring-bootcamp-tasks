package com.spring.vehicleSystem.dao;

import com.spring.vehicleSystem.model.Vehicle;
import com.spring.vehicleSystem.model.Car;
import com.spring.vehicleSystem.model.Bike;
import com.spring.vehicleSystem.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleDAOImpl implements VehicleDAO{
    private DatabaseOperations databaseOperations;

    @Autowired
    public VehicleDAOImpl(DatabaseOperations databaseOperations){
        this.databaseOperations = databaseOperations;
    }

    @Override
    public void save(Vehicle vehicle) {
        String query = "INSERT INTO vehicles (id, brand, type) VALUES (?, ?, ?)";
        try(PreparedStatement preparedStatement = databaseOperations.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, vehicle.getId());
            preparedStatement.setString(2, vehicle.getBrand());
            preparedStatement.setString(3, vehicle.getType());
            preparedStatement.executeUpdate();
            System.out.println("Vehicle saved successfully!");
        } catch (SQLException e) {
            System.out.println("Error saving vehicle: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM vehicles WHERE id = ?";
        try(PreparedStatement preparedStatement = databaseOperations.getConnection().prepareStatement(query)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Vehicle deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting vehicle: " + e.getMessage());
        }
    }

    @Override
    public void update(Vehicle vehicle) {
        String query = "UPDATE vehicles SET brand=?, type=? WHERE id=?";
        try(PreparedStatement preparedStatement = databaseOperations.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, vehicle.getBrand());
            preparedStatement.setString(2, vehicle.getType());
            preparedStatement.setInt(3, vehicle.getId());
            preparedStatement.executeUpdate();
            System.out.println("Vehicle updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating vehicle: " + e.getMessage());
        }
    }

    @Override
    public Vehicle searchById(int id) {
        String query = "SELECT * FROM vehicles WHERE id=?";
        try(PreparedStatement preparedStatement = databaseOperations.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                Vehicle vehicle = createVehicle(rs);
                return vehicle;
            }
        } catch (SQLException e) {
            System.out.println("Error searching vehicle: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> list = new ArrayList<>();
        String query = "SELECT * FROM vehicles";
        try (PreparedStatement preparedStatement = databaseOperations.getConnection().prepareStatement(query)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                list.add(createVehicle(rs));
            }
        } catch (SQLException e){
            System.out.println("Error while getting all vehicles: " + e.getMessage());
        }
        return list;
    }

    private Vehicle createVehicle(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String brand = rs.getString("brand");
        String type = rs.getString("type");
        switch (type.toLowerCase()) {
            case "car":
                return new Car(id, brand, type);
            case "plane":
                return new Plane(id, brand, type);
            case "bike":
                return new Bike(id, brand, type);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}
