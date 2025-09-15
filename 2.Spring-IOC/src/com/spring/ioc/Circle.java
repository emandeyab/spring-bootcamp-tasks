package com.spring.ioc;

import static java.lang.Math.PI;

public class Circle implements Shape{
    private double radius;

    public Circle(){

    }
    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return getRadius() * getRadius() * PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
