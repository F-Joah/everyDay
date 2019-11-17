package com.joah.everyday.N20191117.bridge.color;

public class White implements Color {

    @Override
    public void bepaint(String shape) {
        System.out.println("白色的：" + shape);
    }
}
