package com.joah.everyday.N20191117.decorator.beverage;

public class Espresso extends Beverage {

    public Espresso(){
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
