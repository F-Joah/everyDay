package N201911.N20191111.store;

import com.joah.everyday.N2019.N201911.N20191111.factory.NYPizzaIngredientFactory;
import com.joah.everyday.N2019.N201911.N20191111.factory.PizzaIngredientFactory;
import com.joah.everyday.N2019.N201911.N20191111.pizza.*;
import com.joah.everyday.N2019.N201911.N20191111.pizza.Pizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        switch (type){
            case "cheese":
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("New York Style Cheese Pizza");
                break;
            case "veggie":
                pizza = new VeggiePizza(ingredientFactory);
                pizza.setName("New York Style Veggie Pizza");
                break;
            case "clam":
                pizza = new ClamPizza(ingredientFactory);
                pizza.setName("New York Style Clam Pizza");
                break;
            case "pepperoni":
                pizza = new PepperoniPizza(ingredientFactory);
                pizza.setName("New York Style Pepperoni Pizza");
                break;
            default:
                pizza = null;
        }

        return pizza;
    }
}
