package com.joah.everyday.N201911.N20191113;

public class Client {

    public static void main(String[] args) {
        // 服务员
        KFCWaiter waiter = new KFCWaiter();
        // 套餐A
        MealA mealA = new MealA();
        // 服务员准备套餐A
        waiter.setMealBuilder(mealA);
        // 获得套餐
        Meal meal = waiter.construct();

        System.out.println("<<<------******套餐A的组成部分******------>>>");
        System.out.println(meal.getFood() + "------" + meal.getDrink());

    }
}
