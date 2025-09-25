package com.spring.di.task1;

public class Circle implements Shape{
    private Draw2d draw2d;
    private Draw3d draw3d;
    private double radius;

    public Circle(Draw2d draw2d, Draw3d draw3d){
        this.draw2d = draw2d;
        this.draw3d = draw3d;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println(draw2d.draw2dShape("circle"));
        System.out.println(draw3d.draw3dShape("circle"));
    }
}
