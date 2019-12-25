package com.joah.everyday.N201911.N20191117.decorator;

import com.joah.everyday.N201911.N20191117.decorator.beverage.Beverage;
import com.joah.everyday.N201911.N20191117.decorator.beverage.DarkRoast;
import com.joah.everyday.N201911.N20191117.decorator.beverage.Espresso;
import com.joah.everyday.N201911.N20191117.decorator.condimentDecorator.Milk;
import com.joah.everyday.N201911.N20191117.decorator.condimentDecorator.Mocha;
import com.joah.everyday.N201911.N20191117.decorator.condimentDecorator.Whip;

public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + "  $" + beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Milk(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + "  $" + beverage1.cost());
    }
}
