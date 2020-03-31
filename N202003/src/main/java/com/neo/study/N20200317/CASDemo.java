package com.neo.study.N20200317;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Joah
 * @time 2020/3/17 21:19
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t current data: " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data: " + atomicInteger.get());

    }
}
