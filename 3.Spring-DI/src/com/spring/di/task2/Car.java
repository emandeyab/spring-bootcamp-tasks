package com.spring.di.task2;

public class Car implements Vehicle{
    private Database database;

    public Car(Database database) {
        this.database = database;
    }

    @Override
    public void saveData() {
        System.out.println("database for car:");
        System.out.println("URL: " + database.getUrl() + "\nUserName: " + database.getUsername() + "\nPassword: " + database.getPassword());
    }
}
