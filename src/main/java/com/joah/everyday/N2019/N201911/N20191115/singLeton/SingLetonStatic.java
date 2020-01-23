package com.joah.everyday.N2019.N201911.N20191115.singLeton;

public class SingLetonStatic {

    /**
     * 利用静态变量来记录SingLeton 的唯一实例
     * 直接初始化静态变量，这样就可以确保线程安全了
     */
    private static SingLetonStatic uniqueInstance = new SingLetonStatic();

    /**
     * 构造器私有化，只有SingLeton 类内才可以调用构造器
     */
    private SingLetonStatic(){

    }

    public static SingLetonStatic getInstance(){

        return uniqueInstance;
    }
}
