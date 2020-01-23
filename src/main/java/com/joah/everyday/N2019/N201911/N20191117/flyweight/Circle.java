package com.joah.everyday.N2019.N201911.N20191117.flyweight;

public class Circle extends Shape {

    private String color;

    public Circle(String color){
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("画了一个" + color + "的圆形");
    }
}
