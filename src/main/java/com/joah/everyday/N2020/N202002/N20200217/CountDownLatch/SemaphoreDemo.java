package com.joah.everyday.N2020.N202002.N20200217.CountDownLatch;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * 信号量主要用于两个目的：
 *  一是，用于多个共享资源的互斥使用，
 *  二是，用于并发线程数的控制
 *
 *
 * @author Joah
 * @time 2020/2/17 18:25
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {

            new Thread(() ->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\t 停车 3 秒后，离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放
                    semaphore.release();
                }
            },String.valueOf(i)).start();

        }

    }
}
