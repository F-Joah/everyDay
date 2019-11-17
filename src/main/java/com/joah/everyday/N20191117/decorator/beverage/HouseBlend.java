package com.joah.everyday.N20191117.decorator.beverage;

public class HouseBlend extends Beverage {

    public HouseBlend(){
        description = "HoseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
