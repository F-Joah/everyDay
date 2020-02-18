package com.joah.everyday.N2020.N202002.N20200218.ProdConsumer;

import java.lang.reflect.Field;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{

    /**
     * 默认开启，进行生产 + 消费
     */
    private volatile boolean FLAG = Boolean.TRUE;

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd()throws Exception{
        String data;
        boolean retValue;
        while (FLAG){

            data = atomicInteger.incrementAndGet() + "";

            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);

            if (retValue){
                System.out.println(Thread.currentThread().getName() + "\t 插入队列 ：" + data + "成功");
            }else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列 ：" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停，表示FLAG = false，生产动作结束");
    }

    public void myConsumer()throws Exception{
        String result;
        while (FLAG){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);

            if (null == result || result.equalsIgnoreCase("")){

                FLAG = Boolean.FALSE;
                System.out.println(Thread.currentThread().getName() + "\t 超过 2秒未取到蛋糕，退出消费:");
                System.out.println();
                System.out.println();
                return;
            }

            System.out.println(Thread.currentThread().getName() + "\t 消费队列:" + result + "成功");
        }
    }

    public void stop()throws Exception{
        this.FLAG = Boolean.FALSE;
    }
}

/**
 *
 *  volatile / CAS / atomicInteger / BlockQueue / 线程交互 / 原子引用
 *
 *
 * @author Joah
 * @time 2020/2/18 14:25
 */
public class ProdConsumerBlockQueue {

    public static void main(String[] args) {

        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            System.out.println();
            System.out.println();
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"Prod").start();

        new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
            System.out.println();
            System.out.println();
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();

        System.out.println("5秒时间到了，大老板叫停...");

        try {
            myResource.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
