package com.joah.everyday.N2020.N202002.N20200222.Singleton;

/**
 *
 * 饿汉式
 *
 * @author Joah
 * @time 2020/2/22 18:15
 */
public class SingletonHungry {

    public static final SingletonHungry INSTANCE = new SingletonHungry();

    private SingletonHungry(){

    }

}
