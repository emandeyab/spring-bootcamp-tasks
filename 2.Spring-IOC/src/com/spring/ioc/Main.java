package com.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Circle Area whit radius = 3
        Circle circle = context.getBean("circle", Circle.class);
        circle.setRadius(3);
        System.out.println("Circle Area: " + circle.getArea());

        //Rectangle with length = 3, and width = 4
        Rectangle rectangle = context.getBean("rectangle", Rectangle.class);
        rectangle.setLength(3);
        rectangle.setWidth(4);
        System.out.println("Rectangle Area: " + rectangle.getArea());

    }
}