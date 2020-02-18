package com.joah.everyday.N2020.N202002.N20200217.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joah
 * @time 2020/2/17 12:05
 */
public class FairSyncOrNonfairSync {

    Lock lock = new ReentrantLock(true);

    /**
     *  公平锁 ：指多线程按照申请的顺序来获取锁，类似排队打饭，先来后到
     *
     *  非公平锁：是指多线程获取锁的顺序，并不是按照 申请顺序来到，有可能后申请的线程比先申请的线程有限获取锁，
     *           在高并发的情况下，有可能会造成优先级反转或者饥饿现象
     *
     *  区别：
     *      并发包中 ReentrantLock 的创建 可以指定构造函数的boolean类型来得到公平锁 或 非公平锁，默认是非公平锁
     *
     *      公平锁：Threads acquire a fair lock in the order in which they requested it
     *          公平锁，就是很公平，在并发环境中，每个线程在获取锁时会先查看 此锁维护的等待队列，如果为空，或者当前线程是等待队列的第一个
     *          就占有锁，否则 就会加入到等待队列中，以后会按照 FIFO 的规则从队列中取到自己
     *
     *      非公平锁：a nonfair lock permits barging: threads requesting a lock can jump ahead of the queue of waiting threads if the lock happens to be available when it is requested
     *            非公平锁比较粗鲁，直接尝试占有锁，如果失败，就再次采用类似公平锁的方式
     *
     *
     *  对于  Java ReentrantLock 而言
     *  通过构造函数指定该锁，是否是公平锁（默认非公平） 。非公平锁的优点在于吞吐量比公平锁大
     *
     *  对于 Synchronized 而言，是一种非公平锁
     *
     */

}
