package com.joah.everyday.N20191117.decorator.condimentDecorator;

import com.joah.everyday.N20191117.decorator.beverage.Beverage;

public class Milk extends CondimentDecorator {

    Beverage beverage;

    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Milk";
    }

    @Override
    public double cost() {

        return beverage.cost() + 0.3;
    }
}
