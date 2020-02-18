package com.joah.everyday.N2020.N202002.N20200217.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 *
 *
 * 让一些线程阻塞直到另一些线程完成一系列操作后才被唤醒；
 *
 * CountDownLatch主要有两个方法，当一个或多个线程调用  await方法时，调用线程会被阻塞
 * 其他线程用countDown方法会将计数器减去1 （调用 countDown 方法的线程不会阻塞）
 * 当计数器的值变为零的时候，因调用  await 方法被阻塞的线程会被唤醒，继续执行
 *
 * before
 *  1	 上完自习，离开教室
 *  0	 上完自习，离开教室
 *  2	 上完自习，离开教室
 *  main	 *-*-*-*-*-*-*-*-*-*-*-* 班长最后关门走人
 *  3	 上完自习，离开教室
 *  5	 上完自习，离开教室
 *  4	 上完自习，离开教室
 *
 * after
 *
 *
 * @author Joah
 * @time 2020/2/17 16:39
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        try {

            for (int i = 1; i <= 6; i++) {
                new Thread(() ->{
                    System.out.println(Thread.currentThread().getName() + "\t 国，被灭");
                    countDownLatch.countDown();
                },ContryEnum.forEachContryEnum(i).getRetMessage()).start();
            }

            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + "\t *-*-*-*-*-*-*-*-*-*-*-* 秦帝国，一统华夏");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeDoor(){

        CountDownLatch countDownLatch = new CountDownLatch(6);
        try {

            for (int i = 0; i < 6; i++) {
                new Thread(() ->{
                    System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                    countDownLatch.countDown();
                },String.valueOf(i)).start();
            }

            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + "\t *-*-*-*-*-*-*-*-*-*-*-* 班长最后关门走人");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
