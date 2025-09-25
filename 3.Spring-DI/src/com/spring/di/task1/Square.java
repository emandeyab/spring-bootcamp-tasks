package com.spring.di.task1;

public class Square implements Shape{
    private Draw2d draw2d;
    private Draw3d draw3d;
    private double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Draw3d getDraw3d() {
        return draw3d;
    }

    public void setDraw3d(Draw3d draw3d) {
        this.draw3d = draw3d;
    }

    public Draw2d getDraw2d() {
        return draw2d;
    }

    public void setDraw2d(Draw2d draw2d) {
        this.draw2d = draw2d;
    }

    @Override
    public void draw() {
        System.out.println(draw2d.draw2dShape("Square"));
        System.out.println(draw3d.draw3dShape("Square"));
    }
}
