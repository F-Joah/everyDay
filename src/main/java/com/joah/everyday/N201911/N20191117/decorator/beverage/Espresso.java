package com.joah.everyday.N201911.N20191117.decorator.beverage;

public class Espresso extends Beverage {

    public Espresso(){
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
