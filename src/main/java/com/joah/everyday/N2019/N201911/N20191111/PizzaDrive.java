package com.joah.everyday.N2019.N201911.N20191111;


import com.joah.everyday.N2019.N201911.N20191111.pizza.Pizza;
import com.joah.everyday.N2019.N201911.N20191111.store.NYPizzaStore;

public class PizzaDrive {

    public static void main(String[] args) {

        System.out.println("--------------------------- Ethan 需要的 纽约风味 的 墨西哥烤肠墨鱼披萨 ---------------------------");
        NYPizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza ethanPizz = nyPizzaStore.orderPizza("cheese");
        ethanPizz.setName("超级榴莲");
        System.out.println("Ethan ordered a " + ethanPizz.getName() + "\n");
    }
}
