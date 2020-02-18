package com.joah.everyday.N2020.N202002.N20200216.Volatile;

/**
 * @author Joah
 * @time 2020/2/16 13:40
 */
public class ThreadSafe {
    /**
     * 线程安全性如何获得保证
     * 1、工作内存与主内存同步延迟现象导致的可见性问题
     *  1.1、可以使用 synchronized 或 volatile 关键字解决，他们都可以使一个线程---修改后的变量立即对其他线程课件
     *
     * 2、对于指令重拍导致的可先性问题和有序性问题
     *  2.1、可以利用 volatile 关键字解决，因为 volatile 的另外一个作用就是 禁止 重排序优化
     *
     */
}
