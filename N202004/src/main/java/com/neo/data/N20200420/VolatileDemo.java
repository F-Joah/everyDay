package com.neo.data.N20200420;


import lombok.Data;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Data
class MyDate{

    volatile int number = 0;

    public void addNum(){
        this.number = 60;
    }

    /**
     * 此时 number 有 volatile 修饰，不保证原子性
     */
    public void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }

}

/**
 *  验证 volatile 不保证原子性
 *
 * @author Joah
 * @time 2020/4/20 20:44
 */
public class VolatileDemo {
    public static void main(String[] args) {

        MyDate myDate = new MyDate();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myDate.addPlusPlus();
                    myDate.addAtomic();
                }
            }, String.valueOf(i)).start();
        }
        // 待上面的线程执行完成后再用 main 线程查看最后的数据
        while ( Thread.activeCount() > 2)
        {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally number value is:" + myDate.getNumber());
        System.out.println(Thread.currentThread().getName() + "\t finally atomicInteger number value is:" + myDate.getAtomicInteger());
    }

    /**
     * 1、可以保证可见性
     */
    public void seeOkByVolatile(){
        /**
         * 假如  int number = 0; number 变量之前没有 volatile 关键字修饰
         *
         */
        MyDate myDate = new MyDate();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) {  e.printStackTrace(); }
            myDate.addNum();
            System.out.println(Thread.currentThread().getName() + "\t update num value:" + myDate.number);
        },"Thread Name AAA").start();

        while ( myDate.number == 0)
        {
            //  number 变量之前没有 volatile 关键字修饰 是不会走下去的，会一直等待...
        }
        System.out.println(Thread.currentThread().getName() + "\t main get number is :" + myDate.getNumber());

    }
}
