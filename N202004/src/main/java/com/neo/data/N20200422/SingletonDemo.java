package com.neo.data.N20200422;

/**
 *  单例模式 DCL 不一定安全，因为有指令重排存在
 *
 * @author Joah
 * @time 2020/4/22 20:32
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    private SingletonDemo()
    {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法 SingletonDemo()");
    }

    /**
     * DCL (double check lock 双端检锁机制)
     * @return
     */
    public static SingletonDemo getInstance()
    {
        if (instance == null)
        {
            synchronized (SingletonDemo.class)
            {
                if (instance == null)
                {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
