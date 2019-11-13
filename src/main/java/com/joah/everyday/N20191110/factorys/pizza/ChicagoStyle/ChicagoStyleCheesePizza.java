package com.joah.everyday.N20191110.factorys.pizza.ChicagoStyle;

import com.joah.everyday.N20191110.factorys.pizza.Pizza;

public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza(){

        name = "超大榴莲芝士多多披萨";

        dough = "超厚面团";

        sause = "李子番茄酱";

        toppings.add("芝士丝");
    }

    @Override
    public void cut(){
        System.out.println("把披萨切成方形");
    }
}
