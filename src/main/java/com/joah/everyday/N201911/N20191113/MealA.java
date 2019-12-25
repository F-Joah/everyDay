package com.joah.everyday.N201911.N20191113;

/**
 *  A套餐
 */
public class MealA extends MealBuilder {

    @Override
    public void buildFood() {
        meal.setFood("一盒薯条! ");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯可乐! ");
    }
}
