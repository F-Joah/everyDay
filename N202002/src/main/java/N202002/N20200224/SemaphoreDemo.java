package N202002.N20200224;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * 原理
 *     在信号量上，我们定义了两种操作
 *      acquire（获取）当一个线程调用acquire操作时，它要么通过成功获取信号量（信号量减 1 ）
 *          要么一直等下去，直到有线程释放信号量，或超时
 *
 *      release（释放）实际上会将信号值加 1 ，然后唤醒等待的线程
 *
 *      信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制
 *
 *
 * @author Joah
 * @time 2020/2/24 21:33
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        // 模拟资源类
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    // 抢占资源
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢占到了车位");
                    try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) {  e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName() + "\t 离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    // 释放资源
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
