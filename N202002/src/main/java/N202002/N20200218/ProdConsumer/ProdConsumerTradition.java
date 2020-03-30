package N202002.N20200218.ProdConsumer;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
class ShareData{

    private int number = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    // ++
    public void increment()throws Exception{

        lock.lock();
        try {

            // 1、判断
            while (number != 0){
                // 等待，不能生产
                condition.await();
            }
            // 2、干活儿
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            // 3、通知，唤醒
            condition.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // --
    public void decrement()throws Exception{

        lock.lock();
        try {

            // 1、判断
            while (number == 0){
                // 等待，不能生产
                condition.await();
            }
            // 2、干活儿
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            // 3、通知，唤醒
            condition.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}


/**
 *
 * 题目：一个初始值为 0 的变量，两个线程对其交替操作，一个 加 1，一个 减 1，来 5 轮
 *
 *  1、线程            操作      资源类
 *  2、判断            干活      通知
 *  3、防止虚假唤醒
 *
 *
 * @author Joah
 * @time 2020/2/18 13:14
 */
public class ProdConsumerTradition {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() ->{
            try {
                for (int i = 0; i < 5; i++) {
                    shareData.increment();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(() ->{
            try {
                for (int i = 0; i < 5; i++) {
                    shareData.decrement();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BB").start();


    }
}
