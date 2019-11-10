package com.joah.everyday.N20191110.factory.pizza;

public class PeperoniPizza extends Pizza  {

    @Override
    public void prepare() {
        System.out.println("----------------->>>> prepare PeperoniPizza...");
    }

    @Override
    public void bake() {
        System.out.println("----------------->>>> bake PeperoniPizza...");
    }

    @Override
    public void cut() {
        System.out.println("----------------->>>> cut PeperoniPizza...");
    }

    @Override
    public void box() {
        System.out.println("----------------->>>> box PeperoniPizza...");
    }
}
