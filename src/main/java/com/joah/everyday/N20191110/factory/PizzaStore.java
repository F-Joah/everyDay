package com.joah.everyday.N20191110.factory;


import com.joah.everyday.N20191110.factory.pizza.Pizza;
import org.springframework.stereotype.Service;

/**
 * pizza 商店 ，一个筐
 */
@Service
public class PizzaStore {

    SimplePizzaFactory factory;

    public PizzaStore (SimplePizzaFactory factory){
        this.factory = factory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza ;
        pizza = factory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
