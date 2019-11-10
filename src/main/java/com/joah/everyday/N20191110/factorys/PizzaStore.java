package com.joah.everyday.N20191110.factorys;


import com.joah.everyday.N20191110.factorys.pizza.Pizza;
import org.springframework.stereotype.Service;

/**
 * pizza 商店 抽象类
 */
@Service
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
     * @param item
     * @return
     */
    public abstract Pizza createPizza(String item);
}
