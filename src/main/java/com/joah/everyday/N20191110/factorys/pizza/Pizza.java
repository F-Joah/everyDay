package com.joah.everyday.N20191110.factorys.pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象pizza类
 */
public abstract class Pizza {
    /**
     * 名称
     */
    protected String name;

    /**
     * 面团
     */
    protected String dough;

    /**
     * 酱料
     */
    protected String sause;

    /**
     * 佐料
     */
    protected List<String> toppings = new ArrayList<>();


    public void prepare(){
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough ");
        System.out.println("Adding sause ");
        System.out.println("Adding toppings ");
        for (int i = 0;i < toppings.size();i++){
            System.out.println("   " + toppings.get(i));
        }
    }

    public void bake(){
        System.out.println("Bake for 25 min at 350");
    }

    public void cut(){
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box(){
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName(){

        return name;
    }

}
