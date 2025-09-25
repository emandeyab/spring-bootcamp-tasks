package com.spring.di.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = context.getBean("car", Car.class);
        Plane plane = context.getBean("plane", Plane.class);
        car.saveData();
        System.out.println("///////////////////////////");
        plane.saveData();
    }
}