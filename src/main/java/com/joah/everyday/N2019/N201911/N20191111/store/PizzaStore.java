package com.joah.everyday.N2019.N201911.N20191111.store;

import com.joah.everyday.N2019.N201911.N20191111.pizza.Pizza;

public abstract class PizzaStore {

    public Pizza orderPizza(String type){

        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    /**
     * 创建pizza的方法交给子类去实现
     * @param type
     * @return
     */
    protected abstract Pizza createPizza(String type);
}
