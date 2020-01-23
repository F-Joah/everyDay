package com.joah.everyday.N2019.N201911.N20191110.factorys.pizza.NYStyle;

import com.joah.everyday.N2019.N201911.N20191110.factorys.pizza.Pizza;

public class NYStylePeperoniPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("----------------->>>> prepare ChicagoStylePeperoniPizza...");
    }

    @Override
    public void bake() {
        System.out.println("----------------->>>> bake ChicagoStylePeperoniPizza...");
    }

    @Override
    public void cut() {
        System.out.println("----------------->>>> cut ChicagoStylePeperoniPizza...");
    }

    @Override
    public void box() {
        System.out.println("----------------->>>> box ChicagoStylePeperoniPizza...");
    }
}
