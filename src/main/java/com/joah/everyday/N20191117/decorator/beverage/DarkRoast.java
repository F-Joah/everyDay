package com.joah.everyday.N20191117.decorator.beverage;

public class DarkRoast extends Beverage {

    public DarkRoast(){
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
