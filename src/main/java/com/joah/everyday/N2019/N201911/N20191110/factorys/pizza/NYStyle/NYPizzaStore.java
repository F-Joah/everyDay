package com.joah.everyday.N2019.N201911.N20191110.factorys.pizza.NYStyle;

import com.joah.everyday.N2019.N201911.N20191110.factorys.PizzaStore;
import com.joah.everyday.N2019.N201911.N20191110.factorys.pizza.*;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String item) {
        Pizza pizza = null;

        switch (item){
            case "cheese":
                pizza = new NYStyleCheesePizza();
                break;
            case "veggie":
                pizza = new NYStyleVeggiePizza();
                break;
            case "clam":
                pizza = new NYStyleClamPizza();
                break;
            case "pepperoni":
                pizza = new NYStylePeperoniPizza();
                break;
        }

        return pizza;
    }
}
