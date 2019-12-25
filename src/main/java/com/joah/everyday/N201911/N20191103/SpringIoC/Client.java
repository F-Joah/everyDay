package com.joah.everyday.N201911.N20191103.SpringIoC;

import org.springframework.util.ObjectUtils;

public class Client {

    public static void main(String[] args) {
        Fruit fruit = Factory.getInstance("com.joah.everyday.N201911.N20191103.SpringIoC.Orange");
        if (!ObjectUtils.isEmpty(fruit)){
            fruit.eat();
        }
    }
}
