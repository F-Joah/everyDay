package com.joah.everyday.N2020.N202002.N20200218.BlockingQueue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * *** ArrayBlockingQueue:
 *      一个基于数组结构的   有界阻塞队列，此队列按 FIFO(先进先出)原则对元素进行排序
 *
 * *** LinkedBlockingQueue：
 *      一个基于链表结构的   有界阻塞队列（但大小默认值为 Integer.MAX_VALUE ...大概21亿），此对垒按 FIFO（先进先出）排序元素，吞吐量通常要高于  ArrayBlockingQueue
 *
 * *** SynchronousQueue:
 *      一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入一直处于阻塞状态
 *      与其他BlockingQueue不同，SynchronousQueue是一个不存储记录的BlockingQueue
 *      每个put操作必须要等待一个 take操作，否则不能继续添加元素，反之亦然
 *
 * PriorityBlockingQueue：
 *  支持优先级排序的    无界阻塞队列
 *
 * DelayQueue:
 *  使用优先级队列实现的  延迟无界阻塞队列
 *
 * LinkedTransferQueue：
 *  由链表结构组成的    无界阻塞队列
 *
 * LinkedBlockingDeque:
 *  由链表结构组成的    双向阻塞队列
 *
 *
 *
 * 1、队列
 *
 * 2、阻塞队列
 *      当阻塞队列是空时，从队列中 获取 元素的操作将会被阻塞     有价无市
 *      当阻塞队列是满时，往队列中 添加 元素的操作将会被阻塞     产能过剩
 *      试图从空的阻塞队列中获取元素的线程将会被阻塞，直到其他线程往空的队列插入新的元素
 *      同样
 *      试图往已满的阻塞队列添加新元素的线程同样会被阻塞，直到其他线程从队列中移除一个或者多个元素
 *      或者完全清空队列后使队列变得空闲起来并后续新增
 *
 *
 *
 *  2.1、阻塞队列有没有好的一面
 *      为什么用？有什么好处？
 *      多线程领域：所谓阻塞，在某些情况下会挂起线程（可阻塞），一旦条件满足，被挂起的线程又会自动被唤醒
 *      为什么需要 BlockingQueue
 *      好处是我们不需要关心什么时候需要阻塞线程，什么时候需要唤醒线程，这一切 BlockingQueue都会一手包办
 *
 *      在concurrent包发布以前，在多线程环境下，我们每个程序员都必须去自己控制这些细节，尤其还要兼顾效率和线程安全，
 *      而这会给我们的程序带来不小的复杂度
 *
 *
 *  2.2、不得不阻塞，如何管理
 *
 *  2。3、BlockingQueue的核心方法
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
 *  面试问题：除了 ArrayList 还有 LinkedList 还有什么？     BlockingQueue
 *
 *
 * @author Joah
 * @time 2020/2/18 11:42
 */
public class BlockingQueueDemo {

    public static void main(String[] args)throws Exception {

    }

    public static void timeOut()throws Exception {

        // blockingQueue必须写默认值
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("A", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("B", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("C", 2L, TimeUnit.SECONDS));

        System.out.println(blockingQueue.offer("X", 2L, TimeUnit.SECONDS));
    }

    public static void always()throws Exception{

        // blockingQueue必须写默认值
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");

        System.out.println("=========================");

        // 会一直等待
//        blockingQueue.put("x");

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
    }

    public static void special(){
        // blockingQueue必须写默认值
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 不会抛异常，返回 false
        System.out.println(blockingQueue.offer("x"));

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    public static void exception(){

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        // 判断队列空不空，然后判断 第一个元素是谁
        System.out.println(blockingQueue.element());

//        // 会抛出 java.lang.IllegalStateException: Queue full   异常
//        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

//        // 会抛出  java.util.NoSuchElementException    异常
//        System.out.println(blockingQueue.remove());

    }

}
