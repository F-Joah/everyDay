package N202002.N20200217.Lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * 自旋锁（spinlock）
 *
 * 是指尝试获取锁的线程不hi立即阻塞，而是采用循环的方式去尝试获取锁，
 *  这样的好处是减少线程上下文切换的小号，
 *  缺点是循环会消耗 CPU
 *
 *
 * 题目：实现一个自旋锁
 * 自旋锁好处：循环比较获取 直到成功为止，没用类似 wait 的阻塞
 *
 * 通过 CAS 操作完成自旋锁，A线程先进来，调用 myLock 方法，自己持有锁 5分钟，
 * B随后进来发现当前有线程持有锁，不是null，所以只能通过自旋等待，直到A释放锁后B随后抢到
 *
 *
 * @author Joah
 * @time 2020/2/17 13:40
 */
public class SpinLockDemo {

    /**
     * 原子引用线程
     */
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){

        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in ...");

        while (!atomicReference.compareAndSet(null,thread)){

        }

    }

    public void myUnLock(){

        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);

        System.out.println(Thread.currentThread().getName() + "\t invoked myUnLock ...");

    }

    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(() ->{
            spinLockDemo.myLock();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        },"AA").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() ->{
            spinLockDemo.myLock();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            spinLockDemo.myUnLock();

        },"BB").start();

    }

}
