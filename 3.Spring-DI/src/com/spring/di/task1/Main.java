package com.spring.di.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("////////////////////////////");
        //Retrieve a bean for Circle class and draw the Circle after Apply the Constructor injection

        //         singleton
        //first circle
        Circle circle1 = context.getBean("circle", Circle.class);
        //circle1.draw();
        circle1.setRadius(5);
        System.out.println(circle1);
        System.out.println("radius for c1= " + circle1.getRadius());

        //second circle
        Circle circle2 = context.getBean("circle", Circle.class);
        circle2.setRadius(20);
        System.out.println(circle2);
        System.out.println("radius for c2= " + circle2.getRadius());
        System.out.println("check radius of circle1 after set circle2's radius:");
        System.out.println("radius for c1= " + circle1.getRadius());




        System.out.println("////////////////////////////");
        //Retrieve a bean for Square class and draw the Square after Apply the Setter injection

        //          prototype
        //first square
        Square square1 = context.getBean("square", Square.class);
        //square1.draw();
        square1.setLength(15);
        System.out.println(square1);
        System.out.println("length for square1= " + square1.getLength());

        //second square
        Square square2 = context.getBean("square", Square.class);
        square2.setLength(30);
        System.out.println(square2);
        System.out.println("length for square2= " + square2.getLength());
        System.out.println("check length of square1 after set square2's length:");
        System.out.println("length for square1= " + square1.getLength());

        System.out.println("////////////////////////////");
        context.close();
    }
}