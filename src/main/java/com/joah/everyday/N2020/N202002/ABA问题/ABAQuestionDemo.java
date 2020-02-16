package com.joah.everyday.N2020.N202002.ABA问题;

/**
 * @author Joah
 * @time 2020/2/16 18:12
 */
public class ABAQuestionDemo {

    /**
     * CAS会导致 “ABA问题”
     *
     * CAS算法实现一个重要前提需要取出内存中某时刻的数据，并在当下时刻比较并替换，那么在这个时间差类会导致数据的变化
     * 比如说，一个线程one从内存位置V 中，取出 A,这时候，另一个线程two 也从内存中取出A,并且线程two进行了一些操作，将值变成了B，
     * 然后线程two又将 V位置的数据变成 A，这时候，线程one进行CAS操作发信内存中仍然是A，然后线程one操作成功
     *
     * 尽管线程one 的CAS操作成功，但是不代表这个过程就没有问题
     */

    /**
     * 解决ABA问题
     *  理解原子引用  AtomicReference<T>
     *  新增一种机制，修改版本号，类似时间戳
     */
}
