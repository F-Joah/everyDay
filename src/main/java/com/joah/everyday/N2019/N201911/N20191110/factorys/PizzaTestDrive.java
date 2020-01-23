package com.joah.everyday.N2019.N201911.N20191110.factorys;

import com.joah.everyday.N2019.N201911.N20191110.factorys.pizza.ChicagoStyle.ChicagoPizzaStore;
import com.joah.everyday.N2019.N201911.N20191110.factorys.pizza.NYStyle.NYPizzaStore;
import com.joah.everyday.N2019.N201911.N20191110.factorys.pizza.Pizza;

/**
 * 用于创建pizza的工厂
 */
public class PizzaTestDrive {

    public static void main(String[] args) {

        System.out.println("--------------------------- 小师傅 需要的 芝加哥风味 的 超大榴莲芝士多多披萨 ---------------------------");
        ChicagoPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        Pizza joelPizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println("小师傅 ordered a " + joelPizza.getName() + "\n");

        System.out.println("--------------------------- Ethan 需要的 纽约风味 的 墨西哥烤肠墨鱼披萨 ---------------------------");
        NYPizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza ethanPizz = nyPizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + ethanPizz.getName() + "\n");

    }
}
