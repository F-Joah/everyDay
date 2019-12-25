package com.joah.everyday.N201911.N20191117.flyweight;

public class Client {

    public static void main(String[] args) {
        Shape shape = FlyweightFactory.getShap("灰色");
        shape.draw();

        Shape shape1 = FlyweightFactory.getShap("灰色");
        shape1.draw();

        Shape shape2 = FlyweightFactory.getShap("蓝色");
        shape2.draw();

        Shape shape3 = FlyweightFactory.getShap("红色");
        shape3.draw();

        System.out.println("一共绘制了" + FlyweightFactory.getSum() + "中国颜色的圆形");
    }
}
