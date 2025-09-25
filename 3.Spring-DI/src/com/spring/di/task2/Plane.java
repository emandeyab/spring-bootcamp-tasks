package com.spring.di.task2;

public class Plane implements Vehicle{
    private Database database;

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public void saveData() {
        System.out.println("database for plane:");
        System.out.println("URL: " + database.getUrl() + "\nUserName: " + database.getUsername() + "\nPassword: " + database.getPassword());
    }
}
