package com.joah.everyday.N2020.N202002.Volatile;

/**
 * 单例模式volatile分析
 * @author Joah
 * @time 2020/2/16 13:45
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法 SingletonDemo()");

    }

    /**
     *     /**
     *      *加 synchronized 可以不重复
     *     public static synchronized SingletonDemo getInstance(){
     *
     *         if (instance == null){
     *             instance = new SingletonDemo();
     *         }
     *         return instance;
     *     }
     */

    /**
     *  DCL (Double check lock 双端检验锁机制)
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

        // 单线程（main线程的操作）
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//
//        System.out.println("------------------------------");
//        System.out.println("------------------------------");
//        System.out.println("------------------------------");

        /**
         * 并发、多线程后，情况发生了变化
         */
        for (int i = 1; i <= 10; i++) {
            new Thread(() ->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
