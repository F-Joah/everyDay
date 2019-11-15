package com.joah.everyday.N20191115.singLeton;

public class SingLetonSynchronized {

    /**
     * 利用静态变量来记录SingLeton 的唯一实例
     */
    private static SingLetonSynchronized uniqueInstance;

    /**
     * 构造器私有化，只有SingLeton 类内才可以调用构造器
     */
    private SingLetonSynchronized(){

    }

    public static synchronized SingLetonSynchronized getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new SingLetonSynchronized();
        }
        return uniqueInstance;
    }
}
