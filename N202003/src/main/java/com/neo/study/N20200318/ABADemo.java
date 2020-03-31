package com.neo.study.N20200318;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

@Getter
@ToString
@AllArgsConstructor
class Book{
    private String bookId;
    private String bookName;

}
/**
 * @author Joah
 * @time 2020/3/18 21:31
 */
public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);
    public static void main(String[] args) {
        new Thread(()->{
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        },"Thread Name A1").start();
        new Thread(()->{
            // 保证上面的 A1 线程完成一次ABA
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {  e.printStackTrace(); }
            System.out.println(atomicReference.compareAndSet(100, 2020) + "\t current integer:" + atomicReference.get());
        },"Thread Name A2").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第一次版本号：" + stamp);
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {  e.printStackTrace(); }
            atomicStampedReference.compareAndSet(100, 101,  atomicStampedReference.getStamp(),  atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第二次版本号：" + atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(101, 100,  atomicStampedReference.getStamp(),  atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第三次版本号：" + atomicStampedReference.getStamp());

        },"Thread Name A3").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t 第一次版本号：" + stamp);
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) {  e.printStackTrace(); }
            boolean result = atomicStampedReference.compareAndSet(100, 101,  stamp,  stamp + 1);
            System.out.println(Thread.currentThread().getName() + "修改成功否？：" + result + "\t 第二次版本号：" + stamp);
        },"Thread Name A4").start();
    }
}
