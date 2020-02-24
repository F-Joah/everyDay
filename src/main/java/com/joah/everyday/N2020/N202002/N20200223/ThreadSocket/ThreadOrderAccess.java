package com.joah.everyday.N2020.N202002.N20200223.ThreadSocket;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{

    /**
     * 1:A
     * 2:B
     * 3:C
     */
    private int number = 1;

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5(){

        lock.lock();
        try {
            while (number != 1){
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            number = 2;
            condition2.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try {
            while (number != 2){
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            number = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            while (number != 3){
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            number = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

/**
 *
 * 多线程之间按顺序调用 实现 A->B->C
 *   三个线程之间顺序调用
 *   A打印 5 次，B 打印 10 次，C 打印 15次
 *   接着
 *   A打印 5 次，B 打印 10 次，C 打印 15次
 *   。。。
 *
 *
 *  1、高内聚低耦合 前提下，线程操作资源类
 *
 *  2、判断 / 干活 / 通知
 *
 *  3、多线程交互中，必须防止多线程虚假唤醒，也即(判断，只能用 while 不能用 if)
 *
 *  4、注意标志位
 *
 *
 *
 * @author Joah
 * @time 2020/2/23 16:13
 */
public class ThreadOrderAccess {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        },"Thread Name A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        },"Thread Name B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print15();
            }
        },"Thread Name C").start();
    }
}
