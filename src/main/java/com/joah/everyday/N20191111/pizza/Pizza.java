package com.joah.everyday.N20191111.pizza;

import com.joah.everyday.N20191111.vo.*;
import lombok.Data;

@Data
public abstract class Pizza {

    /**
     * 每个Pizza都有一组在准备时会用到的原料
     */
    String name;

    Dough dough;

    Sauce sauce;

    Veggies veggies[];

    Cheese cheese;

    Pepperoni pepperoni;

    Clams clams;

    public abstract void prepare();

    public void bake(){
        System.out.println("350℃ 烤25min");
    }

    public void cut(){
        System.out.println("把pizza 切成两半");
    }

    public void box(){
        System.out.println("把披萨放在官方的披萨店盒子里");
    }
}
