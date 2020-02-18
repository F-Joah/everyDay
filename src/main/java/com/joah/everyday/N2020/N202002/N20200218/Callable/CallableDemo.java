package com.joah.everyday.N2020.N202002.N20200218.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread1 implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "------------------>>>>>>>>>>>>>>come in callable");
        TimeUnit.SECONDS.sleep(3);
        return 1024;
    }
}

/**
 *
 * 多线程中，第三种获得多线程的方式
 *
 *
 * @author Joah
 * @time 2020/2/18 17:11
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * public FutureTask(Callable<V> callable)
         */
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask1 = new FutureTask<>(new MyThread());

        new Thread(futureTask,"AAA").start();
        new Thread(futureTask1,"BBB").start();

        int result01 = 100;

        /**
         * 要求获得 callable线程的计算结果，如果没有计算完成就要去强求，会导致阻塞，直到计算完成
         */
        while (!futureTask.isDone()){

        }
        int result02 = futureTask.get();

        System.out.println("---------->>>>>>>>> result :" + (result01 + result02));

    }
}
