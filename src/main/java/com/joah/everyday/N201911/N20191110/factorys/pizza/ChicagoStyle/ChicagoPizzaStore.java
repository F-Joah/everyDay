package com.joah.everyday.N201911.N20191110.factorys.pizza.ChicagoStyle;

import com.joah.everyday.N201911.N20191110.factorys.PizzaStore;
import com.joah.everyday.N201911.N20191110.factorys.pizza.*;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String item) {
        Pizza pizza = null;

        switch (item){
            case "cheese":
                pizza = new ChicagoStyleCheesePizza();
                break;
            case "veggie":
                pizza = new ChicagoStyleVeggiePizza();
                break;
            case "clam":
                pizza = new ChicagoStyleClamPizza();
                break;
            case "pepperoni":
                pizza = new ChicagoStylePeperoniPizza();
                break;
        }
        return pizza;
    }
}
