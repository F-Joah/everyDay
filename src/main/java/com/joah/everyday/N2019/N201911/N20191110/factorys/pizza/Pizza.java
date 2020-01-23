package com.joah.everyday.N2019.N201911.N20191110.factorys.pizza;

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
        System.out.println("准备: " + name);
        System.out.println("掷面团 ");
        System.out.println("加酱汁 ");
        System.out.println("添加浇头 ");
        for (int i = 0;i < toppings.size();i++){
            System.out.println("   " + toppings.get(i));
        }
    }

    public void bake(){
        System.out.println("在350℃下烘烤25分钟");
    }

    public void cut(){
        System.out.println("把披萨切成对角片");
    }

    public void box(){
        System.out.println("把披萨放在官方的披萨店盒子里");
    }

    public String getName(){

        return name;
    }

}
