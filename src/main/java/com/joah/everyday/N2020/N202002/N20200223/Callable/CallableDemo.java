package com.joah.everyday.N2020.N202002.N20200223.Callable;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Callable 和 Runnable 区别
 *  1、一个是 run 一个是 call
 *  2、run无返回值       call 有返回值
 *  3、run无异常         call 抛异常
 *
 *
 */
class MyThread implements Runnable{

    @Override
    public void run() {

    }
}

class MyCallableThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {

        System.out.println("******************come in here");
        try { TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e) {  e.printStackTrace(); }
        return 1024;
    }
}

/**
 *
 * 获得多线程的 前 2 种方式
 *  继承 Thread 类
 *  实现 Runnable 接口
 *  java 5 之后变成了四种
 *
 * 多线程中 第 3 种 获得多线程的方法
 *
 *      implements Callable
 *      多肽的思想
 *
 *  1、  get方法一般请放在最后一行
 *
 *
 *
 * @author Joah
 * @time 2020/2/23 21:13
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyCallableThread());

        new Thread(futureTask,"Thread Name A").start();
        new Thread(futureTask,"Thread Name B").start();

        System.out.println(Thread.currentThread().getName() + "*******计算完成" );
        System.out.println(futureTask.get());

    }
}
