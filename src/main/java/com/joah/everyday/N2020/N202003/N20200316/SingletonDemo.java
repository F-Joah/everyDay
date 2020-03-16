package com.joah.everyday.N2020.N202003.N20200316;

/**
 *
 * Singleton一共六种
 *
 * @author Joah
 * @time 2020/3/16 22:50
 */
public class SingletonDemo {

    /**
     * 单线程的时候，没问题，多线程会有线程不安全问题
     *
     *  加 volatile 可以解决，DCL 机制中，指令重排带来的线程不安全问题
     *
     */
    private static volatile SingletonDemo instance = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法");
    }

    /**
     * DCL (Double Check Lock 双端检索机制)
     *  双端检索机制，不一定线程安全，因为有指令重排存在，加入 volatile 可以禁止指令重排
     * @return
     */
    public static SingletonDemo getInstance(){
        if (instance == null){
            synchronized (SingletonDemo.class){
                if (instance == null){
                    instance = new SingletonDemo();
                }
            }

        }
        return instance;
    }

    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());

        System.out.println(Thread.currentThread().getName() + "\t ======================下面是多线程=========================");

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
