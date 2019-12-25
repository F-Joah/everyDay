package com.joah.everyday.N201911.N20191117.decorator.condimentDecorator;

import com.joah.everyday.N201911.N20191117.decorator.beverage.Beverage;

public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }
}
