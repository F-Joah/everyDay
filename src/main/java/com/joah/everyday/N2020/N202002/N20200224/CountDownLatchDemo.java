package com.joah.everyday.N2020.N202002.N20200224;

import java.util.concurrent.CountDownLatch;

/**
 * @author Joah
 * @time 2020/2/24 20:05
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t 离开教室");
                countDownLatch.countDown();

            }, String.valueOf(i)).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t 班长离开教室");
    }

}
