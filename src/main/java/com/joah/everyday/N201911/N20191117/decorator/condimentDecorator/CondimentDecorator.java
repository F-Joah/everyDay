package com.joah.everyday.N201911.N20191117.decorator.condimentDecorator;

import com.joah.everyday.N201911.N20191117.decorator.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {

    @Override
    public abstract String getDescription();
}
