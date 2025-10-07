package com.spring.vehicleSystem;

import com.spring.vehicleSystem.config.AppConfig;
import com.spring.vehicleSystem.controller.VehicleController;
import com.spring.vehicleSystem.model.Car;
import com.spring.vehicleSystem.model.Plane;
import com.spring.vehicleSystem.model.Bike;
import com.spring.vehicleSystem.model.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        VehicleController vehicleController = context.getBean(VehicleController.class);


        //test save Vehile
        //Car
        Car car = context.getBean(Car.class);
        //car.setId(1);
        car.setBrand("BMW");
        car.setType("car");
        //vehicleController.saveVehile(car);


        //Plane
        Plane plane = context.getBean(Plane.class);
        //plane.setId(2);
        plane.setBrand("Airbus");
        plane.setType("plane");
        //vehicleController.saveVehile(plane);


        //Bike
        Bike bike = context.getBean(Bike.class);
        //bike.setId(3);
        bike.setBrand("Honda");
        bike.setType("bike");
        //vehicleController.saveVehile(bike);


        //System.out.println("////////////////////////////////////");
        //test delete
        //vehicleController.deleteVhicle(6);


        //System.out.println("////////////////////////////////////");
        //test update
        /*
        car.setId(1);
        car.setBrand("Mercedes");
        vehicleController.updateVehicle(car);
         */

        System.out.println("////////////////////////////////////");
        //test search
        System.out.println("Id: " + vehicleController.searchById(1).getId() + " Brand: " + vehicleController.searchById(1).getBrand() + " Type: " + vehicleController.searchById(1).getType());
        System.out.println("Id: " + vehicleController.searchById(2).getId() + " Brand: " + vehicleController.searchById(2).getBrand() + " Type: " + vehicleController.searchById(2).getType());
        System.out.println("Id: " + vehicleController.searchById(3).getId() + " Brand: " + vehicleController.searchById(3).getBrand() + " Type: " + vehicleController.searchById(3).getType());

        System.out.println("////////////////////////////////////");
        //test get all vehicles
        List<Vehicle> vehicles = vehicleController.getALL();
        for(Vehicle vehicle : vehicles){
            System.out.println("Id: " + vehicle.getId() + " Brand: " + vehicle.getBrand() + " Type: " + vehicle.getType());
        }


        context.close();

    }
}