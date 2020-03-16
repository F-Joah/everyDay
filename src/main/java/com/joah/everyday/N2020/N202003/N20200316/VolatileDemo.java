package com.joah.everyday.N2020.N202003.N20200316;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{

    volatile int number = 0;

    public void addTo60(){
        number = 60;
    }

    /**
     * 此时的 number加过了 volatile，不保证原子性
     *     不加 synchronized 不能保证原子性，不过 synchronized 太重了
     */
    public void addPlusPlus(){
        number++;
    }

    /**
     * 使用 atomicInteger 来解决，number++ 不保证原子性的问题
     */
    AtomicInteger atomicInteger = new AtomicInteger();

    public void atomicAdd(){
        // atomicInteger++
        atomicInteger.getAndIncrement();
    }

}

/**
 * volatile
 *  1）可见性
 *  2）不保证原子性
 *      2.1) 原子性指什么？
 *          不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割，需要整体完整，要么同时成功，要么同时失败
 *  3）禁止指令重排
 *
 * @author Joah
 * @time 2020/3/16 21:16
 */
public class VolatileDemo {

    public static void main(String[] args) {

        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.atomicAdd();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t int type finally number value:" + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t atomicInteger finally number value:" + myData.atomicInteger);

    }



    /**
     * volatile 的可见性，及时通知其他线程，主物理内存数据已经被修改
     */
    public void seeOkByVolatile(){
        MyData myData = new MyData();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t come in");
            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) {  e.printStackTrace(); }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData.number);
        },"Thread Name A").start();

        // 第二个线程 main
        while (myData.number == 0){
            // main 一直等待，循环，直到 number 值不再等于 0
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over" );
    }
}
