package com.joah.everyday.N2020.N202002.N20200218.ThreadPool;

/**
 *
 * 线程池七大参数
 *      1、corePoolSize
 *          线程池中的常驻核心线程数
 *              1.1、 在创建了线程池后，当有请求任务来了之后，就会安排池中的线程去执行请求任务，近似理解为今日当值线程
 *              1.2、 当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中
 *
 *      2、maximumPoolSize
 *          线程池能够容纳同时执行的最大线程数，此值必须大于等于 1
 *
 *      3、keepAliveTime
 *          多余的空闲线程的存活时间
 *          当线程池数量超过 corePoolSize 时，当空闲时间达到 keepAliveTime 值时，
 *          多余空闲线程会被销毁知道只剩下 corePoolSize 个线程为止
 *
 *          默认情况下
 *          只有当线程中的线程数大于 corePoolSize 时 keepAliveTime 才会起作用，直到线程池中的线程数不大于 corePoolSize
 *
 *      4、unit
 *          keepAliveTime的单位
 *
 *      5、workQueue
 *          任务队列，被提交但尚未被执行的任务
 *
 *      6、threadFactory
 *          标识生产线程池中工作线程的线程工厂，用于创建线程 一般用默认即可
 *
 *      7、handler
 *          拒绝策略，表示当队列满了并且工作线程大于等于线程池的最大线程数（maximumPoolSize）时，如何来拒绝请求执行的 Runnable 的策略
 *
 *
 *
 *
 *
 *  1、在创建一个线程池后，等待提交过来的任务请求
 *  2、当调用 execute()方法添加一个请求任务时，线程池会做如下判断
 *      2.1、如果正在运行的线程数量小于 corePoolSize,那么马上创建线程运行这个任务
 *      2.2、如果正在运行的线程数量大于或等于 corePoolSize，那么将这个任务放入队列
 *      2.3、如果这时候队列满了，且正在运行的线程数量还小于 maximumPoolSize,那么还是要创建非核心线程like运行这个任务
 *      2.3、如果队列满了且正在运行的线程数量大于或者等于 maximumPoolSize,那么线程池会启动和拒绝策略来执行
 *  3、当一个线程完成任务时，它会从队列中取出下一个任务来执行
 *  4、当一个线程无事可做超过一定时间（keepAliveTime）时，线程池会判断：
 *      如果当前运行的线程数大于 corePoolSize，那么这个线程就会被停掉
 *      所以线程池的所有任务完成后  最终会收缩到 corePoolSize的大小
 *
 *
 *
 *
 *
 *
 *
 *
 * @author Joah
 * @time 2020/2/19 14:14
 */
public class ThreadPoolExecutorDemo {

    /**
     * ThreadPoolExecutor 地城源码
     *
     *     public ThreadPoolExecutor(int corePoolSize,
     *                               int maximumPoolSize,
     *                               long keepAliveTime,
     *                               TimeUnit unit,
     *                               BlockingQueue<Runnable> workQueue,
     *                               ThreadFactory threadFactory,
     *                               RejectedExecutionHandler handler) {
     *         if (corePoolSize < 0 ||
     *             maximumPoolSize <= 0 ||
     *             maximumPoolSize < corePoolSize ||
     *             keepAliveTime < 0)
     *             throw new IllegalArgumentException();
     *         if (workQueue == null || threadFactory == null || handler == null)
     *             throw new NullPointerException();
     *         this.corePoolSize = corePoolSize;
     *         this.maximumPoolSize = maximumPoolSize;
     *         this.workQueue = workQueue;
     *         this.keepAliveTime = unit.toNanos(keepAliveTime);
     *         this.threadFactory = threadFactory;
     *         this.handler = handler;
     *     }
     */
}
