package com.spring.di.task1;

public class DatabaseOperations {

    //init method
    public void connectToDatabase(){
        System.out.println("connection to database established ……");
    }

    //destroy method
    public void disconnectFromDatabase(){
        System.out.println("connection to database closed……");
    }

}
