package com.joah.everyday.N2020.N202002.N20200224.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

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
 *   4、BlockingQueue的核心方法
 *
 *  方法类型        抛出异常        特殊值        阻塞           超时
 *    插入           add(e)       offer(e)     put(e)    offer(e,time,unit)
 *    移除          remove()      poll()       take()      poll(time,unit)
 *    检查         element()      peek()       不可用         不可用
 *
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *               |     当阻塞队列满时，再往队列里 add 插入元素 会抛 java.lang.IllegalStateException: Queue full
 * 抛出异常       |
 *               |     当阻塞队列空时，再从队列里 remove 移除元素，会抛 java.util.NoSuchElementException
 *----------------------------------------------------------------------------------------------------------------------
 *               |     插入方法，成功 true 失败 false
 * 特殊值         |
 *               |     移除方法，成功返回出队列的元素，队列里没有则返回 null
 *----------------------------------------------------------------------------------------------------------------------
 *               |     当阻塞队列满时，生产者线程继续往队列里 put元素，队列会一直阻塞生产线，直到put数据or响应中断退出
 * 一直阻塞       |
 *               |     当阻塞队列空时，消费者线程试图从队列里 take元素，队列会一直阻塞消费者线程，直到队列可用
 *----------------------------------------------------------------------------------------------------------------------
 *  超时退出      | 当阻塞队列满时，队列会阻塞生产者线程一定时间，超过限时后，生产者线程会退出
 *----------------------------------------------------------------------------------------------------------------------
 *
 *
 * @author Joah
 * @time 2020/2/24 22:24
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

    }

    public static void offerDemo() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 3 秒没有抢占到资源 会自动释放
        System.out.println(blockingQueue.offer("d", 3L, TimeUnit.SECONDS));

    }

    public static void putTakeDemo() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // 如果满了，会一直阻塞
//        blockingQueue.put("d");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // 如果满了，会一直阻塞
        System.out.println(blockingQueue.take());
    }

    public static void offerPollDemo(){
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 插入的时候，不能再插入，返回 false
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        // 获取的时候，如果没有了，返回null
        System.out.println(blockingQueue.poll());
    }

    public static void elementDemo(){

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));

        // 找队列第一个值
        System.out.println(blockingQueue.element());

    }

    public static void exceptionDemo(){
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        // java.lang.IllegalStateException: Queue full
//        System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        // java.util.NoSuchElementException
//        System.out.println(blockingQueue.remove());

    }

}
