package N202002.N20200216.ABA问题;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA 问题的解决，   AtomicStampedReference
 * @author Joah
 * @time 2020/2/16 18:32
 */
public class ABADemo {

    /**
     * 普通原子引用
     */
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    /**
     * 时间戳原子引用
     */
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {

        System.out.println("====================以下是ABA问题的产生========================");

        new Thread(() ->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        }, "t1").start();

        new Thread(() ->{
            // 暂停一秒钟 t2线程，保证t1线程完成了 ABA 操作
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019) + "\t " + atomicReference.get().toString());
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("====================以下是ABA问题的解决========================");

        // t3 做一次 ABA 操作
        new Thread(() ->{
           int stamp = atomicStampedReference.getStamp();
           System.out.println(Thread.currentThread().getName() + "\t 第1次版本号：" + atomicStampedReference.getStamp());
           // 暂停一秒钟 t3 线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第2次版本号：" + stamp);
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第3次版本号：" + atomicStampedReference.getStamp());

        }, "t3").start();

        new Thread(() ->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第1次版本号：" + stamp);
            // 暂停 3 秒钟 t3 线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(100,2020,stamp,stamp + 1);
            System.out.println(Thread.currentThread().getName()
                    + "\t 修改成功否：" + result
                    + "\t 当前实际最新值：" + atomicStampedReference.getReference()
                    + "\t 当前最新版本号：" + atomicStampedReference.getStamp());
        }, "t4").start();


    }

}
