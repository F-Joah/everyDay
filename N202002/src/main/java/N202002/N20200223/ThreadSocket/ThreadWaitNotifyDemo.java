package N202002.N20200223.ThreadSocket;


class AirCoditioner{

    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        // 1、判断
        while (number != 0){
            this.wait();
        }
        // 2、干活
        number++;

        System.out.println(Thread.currentThread().getName() + "\t " + number);

        // 3、通知
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        // 判断
        while (number == 0){
            this.wait();
        }
        // 干活儿
        number--;
        System.out.println(Thread.currentThread().getName() + "\t " + number);
        // 通知
        this.notifyAll();
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
public class ThreadWaitNotifyDemo {

    public static void main(String[] args) {
        AirCoditioner airCoditioner = new AirCoditioner();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    airCoditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread Name A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                    airCoditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread Name B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    airCoditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread Name C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(400);
                    airCoditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread Name D").start();
    }

}
