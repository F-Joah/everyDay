package N202002.N20200223.ThreadSocket;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NewAirCoditioner{

    private int number = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t " + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t " + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}


/**
 * 题目： 现在两个线程，可以操作初始值为零的一个变量
 *       实现一个线程对该变量 加1，一个线程对该变量 减1
 *       实现交替，来 10 轮，变量初始值为 0
 *
 *
 *
 *  1、高内聚低耦合 前提下，线程操作资源类
 *
 *  2、判断 / 干活 / 通知
 *
 *  3、多线程交互中，必须防止多线程虚假唤醒，也即(判断，只能用 while 不能用 if)
 *
 *
 *
 * @author Joah
 * @time 2020/2/23 14:52
 */
public class ThreadWaitNotifyNewDemo {

    public static void main(String[] args) {
        NewAirCoditioner newAirCoditioner = new NewAirCoditioner();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    newAirCoditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread Name A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                    newAirCoditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread Name B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    newAirCoditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread Name C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(400);
                    newAirCoditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread Name D").start();
    }

}
