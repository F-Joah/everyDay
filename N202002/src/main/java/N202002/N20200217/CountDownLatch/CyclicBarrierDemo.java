package N202002.N20200217.CountDownLatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * CyclicBarrier的字面意思是 可循环（Cyclic） 使用的屏障（Barrier）它要做的事情是，
 * 让一组线程达到一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，
 * 屏障才会打开，所有被屏障拦截的线程才会继续干活儿，线程进入屏障 通过 CyclicBarrier的 await()方法
 *
 * @author Joah
 * @time 2020/2/17 17:45
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() ->{
            System.out.println("-------------------》》》》》》召唤神龙");
        });

        for (int i = 0; i < 7; i++) {
            int finalI = i;
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + "\t 收集到第：" + finalI + "龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
