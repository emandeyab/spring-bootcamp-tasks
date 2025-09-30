package com.spring.vehicleSystem.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@Scope("singleton")
@Getter
public class DatabaseOperations {
    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;



    private Connection connection;

    @PostConstruct
    public void connectToDatabase(){
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully.");
        }catch (SQLException e){
            System.out.println("Failed to connect: " + e.getMessage());
        }
    }
    @PreDestroy
    public void disconnectFromDatabase(){
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection: " + e.getMessage());
        }
    }
}
