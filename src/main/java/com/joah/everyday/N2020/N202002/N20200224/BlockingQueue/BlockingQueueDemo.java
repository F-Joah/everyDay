package com.joah.everyday.N2020.N202002.N20200224.BlockingQueue;

/**
 *
 * 1、阻塞队列是什么？
 *    1.1、当队列是空的时候，从队列中 获取 元素的操作将会被阻塞
 *    1.2、当队列是满的时候，从队列中添加元素的操作将会被阻塞
 *
 *    1.3、试图从空的队列中获取元素的线程将会被阻塞，直到其他线程往空的队列插入新的元素
 *
 *    1.4、试图向满的队列中添加新元素的线程将会被阻塞，直到其他线程从队列中移除一个或多个元素或者完全清空
 *         使队列变得空闲起来并后续新增
 *
 * 2、阻塞队列的用处
 *    2.1、在多线程领域：所谓阻塞，在某些情况下会挂起线程（即阻塞），一旦条件满足，被挂起的线程又会自动被唤醒
 *
 *    2.2、为什么需要 BlockingQueue
 *      2.2.1、好处是我们不需要关心什么时候需要阻塞线程，什么时候需要唤醒线程，
 *              因为这一切 BlockingQueue都给你一手包办了
 *
 *      2.2.2、在concurrent包发布以前，在多线程环境下，我们每个程序员都必须去自己控制这些细节
 *          尤其还要兼顾效率和线程安全，而这会给我们的程序带来不小的复杂度
 *
 *  3、种类分类
 *      ***3.1、ArrayBlockingQueue: 由数组结构组成的有界队列
 *      ***3.2、LinkedBlockingQueue: 由链表结构组成的有界（但大小默认值为 integer.MAX_VALUE）阻塞队列
 *          3.2、PriorityBlockingQueue: 支持优先级排序的无界阻塞队列
 *          3.3、DelayQueue: 使用优先级队列实现的延迟无界阻塞队列
 *      ***3.4、SynchronousQueue: 不存储元素的阻塞队列，也即单个元素的队列
 *          3.5、LinkedTransferQueue: 由链表组成的无界阻塞队列
 *          3.6、LinkedBlockingDeque: 由链表组成的双向阻塞队列
 *
 *
 *
 * @author Joah
 * @time 2020/2/24 22:24
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {

    }
}
