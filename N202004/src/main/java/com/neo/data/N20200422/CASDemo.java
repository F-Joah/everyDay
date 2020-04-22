package com.neo.data.N20200422;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  CAS ===========> compareAndSet
 * @author Joah
 * @time 2020/4/22 21:17
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        // true	 current data:10
        System.out.println(atomicInteger.compareAndSet(5, 10) + "\t current data:" + atomicInteger.get());
        // false	 current data:10
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data:" + atomicInteger.get());

        /**
         *      @param this         当前对象
         *      @param valueOffset  内存偏移量（内存地址）
         *      @param 1
         *      public final int getAndIncrement() {
         *         return unsafe.getAndAddInt(this, valueOffset, 1);
         *     }
         */
        atomicInteger.getAndIncrement();
    }
}
