package com.joah.everyday.N2019.N201911.N20191117.decorator.condimentDecorator;

import com.joah.everyday.N2019.N201911.N20191117.decorator.beverage.Beverage;

public class Soy extends CondimentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }
}
