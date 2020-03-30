package N202002.N20200226.ThreadPool;

import java.util.concurrent.*;

/**
 *
 * 线程池的优势：
 *  线程池做的工作只要是控制运行的线程数量，处理过程中将任务放入队列，然后线程创建后启动这些任务，如果线程数量超过了最大数量，超出数量的线程排队等候。
 *  等其他线程执行完毕，再从队列中取出任务来执行
 *
 *  它主要的特点为：线程复用，控制最大并发数，管理线程
 *
 *  第一：降低资源消耗，通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
 *  第二：提高响应速度。当任务到达时，任务可以不需要等等线程创建就能立即执行
 *  第三：提高线程的可管理性，线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控
 *
 *
 * Executors.newFixedThreadPool(int);
 *      执行长期任务性能好，创建一个线程池
 *      1 池 n 个固定的线程； 有固定的线程数的线程池
 * Executors.newSingleThreadExecutor();
 *      线程一个一个的执行
 *      1 池 1 个工作线程，
 *
 * Executors.newCachedThreadPool();
 *      执行很多短期异步任务，线程池根据需要创建线程
 *      但在先前构建的线程可用时将重用他们，可扩容，遇强则强
 *      1 池 n 线程
 *
 *
 *
 *  底层主要方法:
 *            ThreadPoolExecutor(int corePoolSize,
 *                                  核心线程数  --->   今日当值窗口
 *
 *                               int maximumPoolSize,
 *                                  可扩容的总线程数 --->  扩容窗口
 *
 *                               long keepAliveTime,
 *                                  扩容线程失效时间    --->    没业务后，多长时间失效
 *
 *                               TimeUnit unit,
 *                                  时间单位
 *
 *                               BlockingQueue<Runnable> workQueue,
 *                                  阻塞队列
 *
 *                               ThreadFactory threadFactory,
 *                               RejectedExecutionHandler handler
 *                                  拒绝策略
 *                               )
 *
 *
 *  1、在创建线程池后，开始等待请求
 *  2、当调用 execute() 方法添加一个请求任务时，线程池会做出如下判断
 *      2.1、如果正在运行的线程数量小于 corePoolSize，那么马上创建线程运行这个任务
 *      2.2、如果正在运行的线程数量大于或等于 corePoolSize，那么将这个任务放入队列
 *      2.3、如果这个时候队列满了，且正在运行的线程数量还小于 maximumPoolSize，那么还是要创建非核心线程立即运行这个任务
 *      2.4、如果队列满了，且正在运行的线程数量大于或等于 maximumPoolSize,那么线程池会启动饱和拒绝策略来执行
 *  3、当一个线程完成任务时，它会从队列中取下一个任务来执行
 *  4、当一个线程无事可做超过一定时间（keepAliveTime）时，线程会判断:
 *      如果当前运行的线程数大于 corePoolSize，那么这个线程就被停掉
 *      所以线程池的所有任务完成后，他最终会收缩到 corePoolSize 的大小
 *
 *
 *
 *  线程池用那个？生产中如何设置合理参数？
 *
 *
 */

/**
 * @在工作中 单一的 / 固定数的 / 可变的  三种创建线程池的方法那个用的最多？
 *          @TODO 都不会用！！！工作中都使用自定义的
 *
 *          为什么？
 *          【强制】 线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，
 *                  这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 *           说明：Executors 返回的线程池对象的弊端如下：
 *              1)FixedThreadPool 和 SingleThreadPool:
 *                  允许请求队列长度为 Integer.MAX_VALUE,可能会堆积大量的请求，从而导致 OOM，
 *              2)CachedThreadPool 和 ScheduledThreadPool:
 *                  允许创建线程数量为 Integer.MAX_VALUE,可能会创建大量的线程，从而导致 OOM
 *
 */


/**
 * 线程池拒绝策略
 *
 *  是什么？
 *      等待队列已满了，再也塞不下新任务了
 *      同时，
 *      线程池中 max 线程也达到了，无法继续为新任务服务
 *
 *      这个时候，我们就需要拒绝策略机制合理的处理这个问题了
 *
 *  JDK内置拒绝策略：
 *      1、AbortPolicy(默认)    直接抛出 RejectedExecutionException 异常阻断系统正常运行
 *
 *      2、CallerRunsPolicy    调用者运行一种调节机制，该策略既不会抛弃任务，也不会抛出异常，
 *                             而是将某些任务回退到调用者，从而降低新任务的流量
 *
 *      3、DiscardOldestPolicy 抛弃队列中等待最久的任务，然后把当前任务加入队列中，尝试再次提交当前任务
 *
 *      4、DiscardPolicy     该策略 默默的丢弃无法处理的任务，不予任何处理也不抛异常。
 *                          如果允许任务丢失，这是最好的一种策略
 *
 *
 *
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {

        /**
         * 手写线程池
         *
         * 线程池数量的配置
         *  CPU密集型：
         *      int num = Runtime.getRuntime().availableProcessors();
         *      maximumPoolSize = num + (1~2)
         *
         *  IO 密集型：
         *
         *
         */



        /**
         * 拒绝策略：中断拒绝策略
         *       new ThreadPoolExecutor.AbortPolicy()   （直接报错，抛异常）
         *       java.util.concurrent.RejectedExecutionException
         *
         */
        ExecutorService threadPoolAbortPolicy = new ThreadPoolExecutor(2,
                                                        5,
                                                        2L,
                                                        TimeUnit.SECONDS,
                                                        new LinkedBlockingQueue<>(3),
                                                        Executors.defaultThreadFactory(),
                                                        new ThreadPoolExecutor.AbortPolicy());
        /**
         * 拒绝策略：调用者运行机制
         *
         *  new ThreadPoolExecutor.CallerRunsPolicy()
         *  谁是调用者，回到谁
         *
         */
        ExecutorService threadPoolCallerRunsPolicy = new ThreadPoolExecutor(2,
                                                        5,
                                                        2L,
                                                        TimeUnit.SECONDS,
                                                        new LinkedBlockingQueue<>(3),
                                                        Executors.defaultThreadFactory(),
                                                        new ThreadPoolExecutor.CallerRunsPolicy());

        /**
         * 拒绝策略：丢弃策略
         *
         *  new ThreadPoolExecutor.DiscardPolicy()
         *
         */
        ExecutorService threadPoolDiscard = new ThreadPoolExecutor(2,
                                                        5,
                                                        2L,
                                                        TimeUnit.SECONDS,
                                                        new LinkedBlockingQueue<>(3),
                                                        Executors.defaultThreadFactory(),
                                                        new ThreadPoolExecutor.DiscardPolicy());


        /**
         * 丢弃策略： 丢弃最老的
         *
         * 丢弃最久等待的
         *
         */
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                                                        5,
                                                        2L,
                                                        TimeUnit.SECONDS,
                                                        new LinkedBlockingQueue<>(3),
                                                        Executors.defaultThreadFactory(),
                                                        new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            /**
             * 当线程数大于 最大线程数 8 的时候，会报错
             *
             *  拒绝执行异常
             * java.util.concurrent.RejectedExecutionException
             *
             * 调用者运行一种调节机制
             *  会回退到调用者 main
             *
             * 丢弃策略
             *  会丢弃不能完成的任务
             *
             * 丢弃最老策略
             *  丢弃等待最久的
             *
             *
             */
            for (int i = 0; i < 9; i++) {
                threadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }



    }

    public static void initPool(){

        /**
         * 1 池 5 个受理线程
         * 类似 1 个银行 5 个窗口
         *
         * new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>());
         *
         */
        ExecutorService threadPoolNewFixed = Executors.newFixedThreadPool(5);

        /**
         * 1 池 1 个工作线程，
         * 类似 1 个银行 1 个窗口
         *
         * new ThreadPoolExecutor(1, 1,
         *                                     0L, TimeUnit.MILLISECONDS,
         *                                     new LinkedBlockingQueue<Runnable>()));
         *
         */
        ExecutorService threadPoolSingle = Executors.newSingleThreadExecutor();


        /**
         *  1 池 n 线程  自适应
         *
         *  new ThreadPoolExecutor(0, Integer.MAX_VALUE,
         *                                       60L, TimeUnit.SECONDS,
         *                                       new SynchronousQueue<Runnable>());
         *
         *
         */
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {  e.printStackTrace(); }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
