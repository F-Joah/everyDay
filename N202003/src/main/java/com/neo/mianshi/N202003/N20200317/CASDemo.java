package com.neo.mianshi.N202003.N20200317;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS 比较交换
 *
 * @author Joah
 * @time 2020/3/17 21:07
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        /**
         * @param expect the expected value
         * @param update the new value
         */
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t current data: " + atomicInteger.get());
    }

}
