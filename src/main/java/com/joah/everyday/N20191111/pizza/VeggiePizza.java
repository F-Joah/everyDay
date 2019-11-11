package com.joah.everyday.N20191111.pizza;

import com.joah.everyday.N20191111.factory.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    /**
     * 要制作披萨必须要有制作披萨的原料， 而这些原料是从原料工厂来的
     * @param ingredientFactory
     */
    public VeggiePizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
        prepare();
    }

    /**
     * 实现prepare方法
     * prepare 方法一步一步地创建芝士比萨，每当需要原料时，就跟工厂要
     */
    @Override
    public void prepare() {
        System.out.println("Prepareing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
