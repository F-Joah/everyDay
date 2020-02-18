package com.joah.everyday.N2020.N202002.N20200217.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁，（递归锁）
 *
 * 指的是同意线程 外层函数 获得锁之后，内层递归函数能获取该锁的代码，
 * 在同一线程在外层方法获取锁的时候，再进入内层方法会自动获取锁
 *
 * 也就是说
 *  线程可以进入任何一个它已经拥有的锁 所同步着的代码块
 *
 *
 *  ReentrantLock / Synchronized 就是典型的 可重入锁
 *
 *  可重入锁，最大的作用是避免死锁
 *
 *
 * case one synchronized 是一个典型的 可重入锁
 * 代码运行结果：
 *  t1	 invoked sendSMS()              t1线程在 外层方法 获取锁的时候
 *  t1	 ########invoked sendEmail()    t1在进入 内层方法会 自动获取锁
 *  t2	 invoked sendSMS()
 *  t2	 ########invoked sendEmail()
 *
 * case two ReentrantLock 是一个典型的 可重入锁
 * 代码运行结果：
 *  Thread-1	 invoked get()
 *  Thread-1	 invoked set()
 *  Thread-0	 invoked get()
 *  Thread-0	 invoked set()
 *
 *
 * @author Joah
 * @time 2020/2/17 12:26
 */

class Phone implements Runnable{

    public synchronized void sendSMS() throws Exception{

        System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception{

        System.out.println(Thread.currentThread().getName() + "\t ########invoked sendEmail()");
    }

    //  ======================================================

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public void get(){
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void set(){
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked set()");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() ->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(() ->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * lock / unLock
         */
        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);

        t3.start();
        t4.start();

    }
}
