package com.joah.everyday.N2020.N202002.N20200217.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 题目：synchronized 和 lock 有什么区别？用新的 Lock有什么好处？请举例说明
 *  1、原始构成
 *      synchronized属于 jvm 层，是Java关键字
 *          monitorenter（底层是通过monitor对象来完成，其实 wait / notify等方法也依赖于 monitor对象，
 *              只有再同步块或方法中才能调用wait/notify等方法）
 *          monitorexit
 *      lock是Java 的类 java.util.concurrent.locks.Lock 是api层面的锁
 *  2、使用方法：
 *      synchronized 不需要用户去手动释放锁，当 synchronized代码执行系统会让线程释放对锁的占用
 *      ReentrantLock 则需要用户去手动释放锁，若没有主动释放锁，则可能会导致出现死锁现象
 *      需要Lock()和unLock()方法配合 try/finally语句块来完成
 *
 *  3、等待是否可中断
 *      synchronized    不可中断，除非抛出异常，或者正常运行完成
 *      ReentrantLock   可中断，
 *                          1、设置超时的方法 tryLock(long timeout, TimeUnit unit)
 *                          2、lockInterruptibly()放代码块中，调用 interrupt()方法可中断
 *
 *  4、加锁是否公平:
 *      synchronized    非公平锁
 *      ReentrantLock   两者都可以，默认 非公平锁，  构造方法可传入  boolean 值，true为贡藕锁，false为非公平锁
 *
 *  5、锁绑定多个条件 Condition
 *      synchronized    没有
 *      ReentrantLock   用来实现分组唤醒需要唤醒的线程们，都可以精确唤醒，而不是像 synchronized妖媚随机唤醒一个，要么全部唤醒
 *
 *
 *
 *
 *
 *
 * 题目：多线程之间按顺序调用，实现 A - > B -> C三个线程启动，要求如下就：
 *      AA打印 5次，BB 打印10 次，CC打印15次
 *      紧接着
 *      AA打印 5次，BB 打印10 次，CC打印15次
 *      ...
 *      来 10 轮
 *
 *
 * @author Joah
 * @time 2020/2/18 13:38
 */

class ShareResource{
    /**
     *  A:1 B:2 C:3
     */
    private int number = 1;

    private Lock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            // 1、判断
            while (number != 1){
                c1.await();
            }
            // 2、干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3、通知
            number = 2;
            c2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try {
            // 1、判断
            while (number != 2){
                c2.await();
            }
            // 2、干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3、通知
            number = 3;
            c3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            // 1、判断
            while (number != 3){
                c3.await();
            }
            // 2、干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3、通知
            number = 1;
            c1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }



}

public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {

        ShareResource shareResource = new ShareResource();

        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        },"AAA").start();

        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        },"BBB").start();

        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                shareResource.print15();
            }
        },"CCC").start();

    }
}
