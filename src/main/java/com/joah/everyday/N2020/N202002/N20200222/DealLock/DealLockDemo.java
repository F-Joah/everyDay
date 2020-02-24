package com.joah.everyday.N2020.N202002.N20200222.DealLock;


import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        synchronized (lockA){

            System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获取：" + lockB);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockB + "\t 尝试获取：" + lockA);
            }
        }
    }
}


/**
 *
 *  死锁是什么？
 *      死锁，是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互斥等待的现象，若无外力干涉，那它们都将无法推进下去，
 *      如果系统资源充足，进程的资源请求都能够得到满足，死锁出现的可能性就很低，否则会因争夺有限的资源而陷入死锁
 *
 *  死锁产生的主要原因？
 *      系统资源不足
 *      进程运行推进的顺序不合适
 *      资源分配不当
 *
 *  解决
 *      jps命令定位进程号
 *      jstack找到死锁查看
 *
 * @author Joah
 * @time 2020/2/22 15:21
 */
public class DealLockDemo {

    public static void main(String[] args) {

        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA,lockB),"ThreadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"ThreadBBB").start();

        /**
         *
         * window 下的 java 运行程序 也有类似 ps的查看进程的命令，目前我们需要查看的只有 java
         *      jps = java ps       jps -l
         *
         */

    }
}
