package com.joah.everyday.N20191110.factorys;

import com.joah.everyday.N20191110.factorys.pizza.*;
import org.springframework.stereotype.Component;

/**
 * 用于创建pizza的工厂
 */
@Component
public class SimplePizzaFactory {

    public Pizza createPizza(String type){

        Pizza pizza = null;
        /**
         * 创建四种商品
         */
        if ("cheese".equals(type)){
            pizza = new NYStyleCheesePizza();
        }

        if ("clam".equals(type)){
            pizza = new ClamPizza();
        }

        if ("pepperoni".equals(type)){
            pizza = new PeperoniPizza();
        }

        if ("veggie".equals(type)){
            pizza = new VeggiePizza();
        }

        return pizza;
    }

}
