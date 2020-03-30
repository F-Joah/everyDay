package N202002.N20200223.JUC;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 *
 */
class Ticket {

    private int number = 30;

    /**
     * 可重用锁
     */
    private Lock lock = new ReentrantLock();

    public void saleTicket(){

        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName() + "\t 卖出第：" + (number--) + "张票\t还剩下：" + number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 *
 * 题目：三个售货员     卖出      30张票
 *
 *  多线程编程的企业级套路 + 模板
 *
 *  1、在 高内聚 低耦合的前提下 线程  操作(对外暴露的方法)  资源类
 *  2、
 *
 *
 * @author Joah
 * @time 2020/2/23 11:05
 */
public class SaleTicket {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"C").start();


        /**
         *  new Thread(new Runnable() {
         *             @Override
         *             public void run() {
         *                 for (int i = 0; i < 40; i++) {
         *                     ticket.saleTicket();
         *                 }
         *             }
         *         },"A").start();
         *
         *         new Thread(new Runnable() {
         *             @Override
         *             public void run() {
         *                 for (int i = 0; i < 40; i++) {
         *                     ticket.saleTicket();
         *                 }
         *             }
         *         },"B").start();
         *
         *         new Thread(new Runnable() {
         *             @Override
         *             public void run() {
         *                 for (int i = 0; i < 40; i++) {
         *                     ticket.saleTicket();
         *                 }
         *             }
         *         },"C").start();
         */

    }
}
