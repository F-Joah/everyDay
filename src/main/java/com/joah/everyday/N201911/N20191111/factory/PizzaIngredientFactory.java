package com.joah.everyday.N201911.N20191111.factory;

import com.joah.everyday.N201911.N20191111.vo.*;

public interface PizzaIngredientFactory {

    /**
     * 在接口中，每个原料都有一个对应的方法创建该原料
     * @return
     */
    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClams();


}
