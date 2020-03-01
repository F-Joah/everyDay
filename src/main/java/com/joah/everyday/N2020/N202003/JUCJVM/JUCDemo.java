package com.joah.everyday.N2020.N202003.JUCJVM;

import com.joah.everyday.N2019.N201911.N20191117.facade.AirCondition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * lock     unlock
 */
class Ticket{
    private int number = 30;
    private Lock lock = new ReentrantLock();

    public void saleTicket(){
        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName() + "\t 卖出第:" + (number--) + "张票\t 还剩下：" + number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * 读写锁  ReadWriteLock
 *  读 - 读 能共存
 *  读 - 写 不能共存
 *  写 - 写 不能共存
 */
class Cache{
    private volatile Map<String, String> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, String value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 写入数据开始");
            try { TimeUnit.MICROSECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "\t 写入数据完成" + value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 读取数据开始");
            try { TimeUnit.MICROSECONDS.sleep(300); } catch (InterruptedException e) {  e.printStackTrace(); }
            String result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取数据结束" + result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

}

/**
 * 多线程操作
 *      判断 / 干活 / 通知
 */
class AirConditioner{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment(){
        lock.lock();
        try {
            // 1、判断
            while (number != 0 ){
                condition.await();// this.wait()
            }
            // 2、干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t " + number);
            // 3、通知（全部唤醒）
            condition.signalAll();// this.notifyAll()
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            // 1、判断
            while (number == 0 ){
                condition.await();// this.wait()
            }
            // 2、干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t " + number);
            // 3、通知（全部唤醒）
            condition.signalAll();// this.notifyAll()
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

/**
 * 多线程之间按顺序调用，实现 A -> B -> C
 *
 */
class ShareResource{
    /**
     * 1:A  2:B  3:C
     */
    private int number = 1;
    private Lock lock = new ReentrantLock();
    /**
     * 精准唤醒 / 工作
     */
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            // 1、判断
            while (number != 1){
                c1.await();
            }
            // 2、干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t A" + i);
            }
            number = 2;
            // 3、通知
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            // 1、判断
            while (number != 2){
                c2.await();
            }
            // 2、干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t B" + i);
            }
            number = 3;
            // 3、通知
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try {
            while (number != 3){
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t C" + i);
            }
            number = 1;
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * 四种获得多线程的方式
 *      继承 Thread 类
 *      实现 Runnable 接口
 *      实现 Callable 接口 通过 FutureTask 包装器来创建 Thread 线程
 *
 */
class MyCache1 extends Thread{

}

class MyCache2 implements Runnable{

    @Override
    public void run() {

    }
}

/**
 * Callable 和 Runnable 的区别
 *      1、实现方法不同 run / call
 *      2、有无返回值
 *      3、是否抛出异常
 *
 */
class MyCache3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("****** come in Callable");
        try { TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e) {  e.printStackTrace(); }
        return 1024;
    }
}

/**
 * 资源类
 */
class User{
    private Integer id;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User (Integer id, String name, Integer age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

/**
 * 分支合并框架
 */
class MyTask extends RecursiveTask<Integer>{

    private static final Integer ADJUST_VALUE = 10;
    private int start;
    private int end;
    private int reslut;

    public MyTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if (end - start <= ADJUST_VALUE){
            for (int i = start; i <= end; i++) {
                reslut = reslut + i;
            }
        }else {
            int middle = (start + end) / 2;
            // start = 0; middle = 50;
            MyTask task1 = new MyTask(start, middle);
            // middle + 1 = 51; end = 100;
            MyTask task2 = new MyTask(middle + 1, end);
            // 递归回调
            task1.fork();
            task2.fork();
            // 将两条分支相加
            reslut = task1.join() + task2.join();
        }

        return reslut;
    }
}
/**
 * @author Joah
 * @time 2020/3/1 11:03 ~ 15:08
 */
public class JUCDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        completableFuture();
    }

    /**
     * 异步回调
     */
    public static void completableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() ->{
            System.out.println(Thread.currentThread().getName() + "\t completableFuture");
//            int age = 10 / 0;
            return 1024;
        });
        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println(Thread.currentThread().getName() + "\t T: " + t);
            System.out.println(Thread.currentThread().getName() + "\t U: " + u);
        }).exceptionally(f -> {
            // 如果发生异常如何处理
            System.out.println(Thread.currentThread().getName() + "\t exception:" + f.getMessage());
            return 4444;
        }).get());
    }

    /**
     * 拆解成小任务去处理  分支 合并框架 （递归）
     *      递归实现 0 + 1 + 2 + ... +100
     */
    public static void gaussianFunction() throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0, 100);
        // forkJoinPool 是 ExecutorService 的实现类，因此也是一种特殊的线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 获取任务回调
        ForkJoinTask<Integer> submit = forkJoinPool.submit(myTask);
        System.out.println(submit.get());

        // 关闭线程池
        forkJoinPool.shutdown();
    }

    /**
     * Java 8 流式编程
     */
    public static void streamDemo(){
        User user1 = new User(11,"fancy",11);
        User user2 = new User(12,"neo",21);
        User user3 = new User(13,"Twitter",31);

        List<User> list = Arrays.asList(user1,user2,user3);
        /**
         * 过滤 id 是偶数，年龄 > 20 ，把姓名转换成 大写
         */
        list.stream().filter(t -> {
            return t.getId() % 2 == 0;
        }).filter(a -> {
            return a.getAge() > 20;
        }).map(n -> {
            return n.getName().toUpperCase();
        }).forEach(System.out::println);

    }

    /**
     * T get(); 供给型接口，无参数，有返回值
     */
    public static void supplierStreamDemo(){
        Supplier<String> stringSupplier = () ->{
            return UUID.randomUUID().toString();
        };
        System.out.println(stringSupplier.get());
    }

    /**
     * consumer.accept(T t)；    消费型接口，一个参数，无返回
     */
    public static void consumerStreamDemo(){
        Consumer<String> consumer = t ->{
            System.out.println(t);
        };
        consumer.accept("Hello Java");
    }

    /**
     * boolean test(T t);断定型接口  一个参数，返回 boolean
     */
    public static void predicateStreamDemo(){
        Predicate<String> predicate = t ->{
            return t.startsWith("a");
        };
        System.out.println(predicate.test("abc"));

    }

    /**
     * R apply(T t); 函数型接口，一个参数，一个返回值
     */
    public static void functionStreamDemo(){
        Function<String, Integer> function = s -> {
            return s.length();
        };
        System.out.println(function.apply("1234567890"));
    }

    /**
     *      4、线程池用那个？工作中是否创建过线程池？
     *          4.1、线程池不允许使用  Executors 去创建，而是通过 ThreadPoolExecutor 的方式
     *          4.2、如何设置最大工作线程数： maximumPoolSize
     *              最佳最大工作线程数 = （(线程等待时间 / 线程cpu工作时间) + 1） * cpu数目
     *          4.3、获取电脑cpu内核数  System.out.println(Runtime.getRuntime().availableProcessors());
     *              假如 cpu 密集型：设置 maximumPoolSize 数为电脑 cpu 的内核数加 1 or 2
     *              假如 io 密集型： 电脑 cpu 的内核数 * 2 + 1
     *
     */
    public static void writeThreadPoolDemo(){
        ExecutorService threadPool = new ThreadPoolExecutor( 2,
                                                             5,
                                                             3L,
                                                              TimeUnit.SECONDS,
                                                              new ArrayBlockingQueue<>(3),
                                                              new ThreadPoolExecutor.DiscardPolicy());
        /**
         * 拒绝策略
         *      默认 new ThreadPoolExecutor.AbortPolicy()
         *          直接抛出异常阻断系统运行  java.util.concurrent.RejectedExecutionException
         *      new ThreadPoolExecutor.CallerRunsPolicy()
         *          不会抛异常，
         *          也不会抛弃任务，而是将某些任务回退到调用者（main）
         *      new ThreadPoolExecutor.DiscardOldestPolicy()
         *          不会抛异常，
         *          但是会抛弃等待最久的任务，然后把当前任务加入阻塞队列中尝试再次提交当前任务
         *      new ThreadPoolExecutor.DiscardPolicy()
         *          不会抛异常，
         *          可是会默默的丢弃无法处理的任务，不予任何处理也不抛异常，如果允许任务丢弃，这是最好的一种策略
         *
         */
        try {
            for (int i = 0; i < 10; i++) {
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

    /**
     *  线程池
     *      1、获取线程池的 三种方式   1 - 1      1 - 5       1 - n
     *
     *      2、线程池的七大参数
     *          int corePoolSize,
     *              线程池中的常驻的核心线程数
     *          int maximumPoolSize,
     *              线程池中能够容纳同时执行的最大线程数，此值必须大于 1
     *          long keepAliveTime,
     *              存活时间，多余的空闲线程的存活时间，当前线程的数量超过 keepAliveTime 时，多余线程会被销毁直到只剩下 corePoolSize 个线程为止
     *          TimeUnit unit,
     *              存活时间单位
     *          BlockingQueue<Runnable> workQueue,
     *              阻塞队列，存放被提交但尚未被执行的程序
     *          ThreadFactory threadFactory,
     *              表示生产线程池中工作线程的线程工厂，用于创建线程，一般默认即可
     *          RejectedExecutionHandler handler
     *              拒绝策略，表示当阻塞队列满了，并且工作线程数大于等于 maximumPoolSize（最大线程数）时，
     *                  如何来拒绝请求执行的runnable的策略
     *
     *     3、线程池工作原理：
     *          3.1、在创建线程后，开始等待请求
     *          3.2、当调用 execute()方法添加一个请求任务时，线程池会做出如下判断
     *              3.2.1、如果正在运行的线程数量小于 corePoolSize 那么马上创建线程运行这个任务
     *              3.2.2、如果正在运行的线程数量大于或等于 corePoolSize，那么将这个任务放入 阻塞队列
     *              3.2.3、如果这个时候，阻塞队列满了，且正在运行的线程数量小于 maximumPoolSize，
     *                  那么此时会创建 非核心线程  来运行阻塞队列中的任务，线程进入阻塞队列排队等候
     *              3.2.4、如果阻塞队列满了，且此时正在运行的线程数量 大于等于 maximumPoolSize
     *                  那么线程池会启动 饱和拒绝策略来执行
     *          3.3、当一个线程完成任务时，他会从阻塞队列中取出下一个任务来执行
     *          3.4、当一个线程无事可做超过 keepAliveTime 时间的时候，线程会判断
     *              3.4.1、如果当前运行的线程数大于 corePoolSize 那么这个线程会被停掉
     *              3.4.2、当所有线程池中的任务都完成后，线程池线程数量会收缩到  corePoolSize 的大小
     *
     *
     */
    public static void getThreadPool(){
        /**
         *  线程池   1 池 5 线程
         *          public static ExecutorService newFixedThreadPool(int nThreads) {
         *              return new ThreadPoolExecutor(nThreads, nThreads,
         *                                          0L, TimeUnit.MILLISECONDS,
         *                                          new LinkedBlockingQueue<Runnable>());
         *          }
         *
         *  超过的线程会在队列中等待
         *
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        /**
         * 线程池 1 池 1 线程
         *
         *    public static ExecutorService newSingleThreadExecutor() {
         *         return new FinalizableDelegatedExecutorService
         *             (new ThreadPoolExecutor(1, 1,
         *                                     0L, TimeUnit.MILLISECONDS,
         *                                     new LinkedBlockingQueue<Runnable>()));
         *     }
         *
         *  创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序执行
         *
         *
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        /**
         * 多线程  1 池 多线程
         *
         *     public static ExecutorService newCachedThreadPool() {
         *         return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
         *                                       60L, TimeUnit.SECONDS,
         *                                       new SynchronousQueue<Runnable>());
         *     }
         *
         *  创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则建新线程
         *
         *
         */
        ExecutorService threadPool = Executors.newCachedThreadPool();

        // 模拟 10 个外部请求
        try {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                threadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务 \t" + finalI);
                });
                try { TimeUnit.MICROSECONDS.sleep(200); } catch (InterruptedException e) {  e.printStackTrace(); }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    /**
     * 设置阻塞队列超时时间，超过时限后，生产者线程会退出
     * @throws InterruptedException
     */
    public static void arrayBlockingOfferPollTimeDemo() throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        /**
         * 等待三秒后返回false
         */
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        /**
         * 等待三秒后返回 null
         */
        blockingQueue.poll(3L,TimeUnit.SECONDS);
    }

    /**
     *  new ArrayBlockingQueue(3);      put     take            一直等待可以获取 / 添加 资源
     *
     * @throws InterruptedException
     */
    public static void arrayBlockingPutTake() throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        /**
         * 如果资源已满，会一直等待
         */
//        blockingQueue.put("a");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        /**
         * 如果资源已经释放空了，依然会等待获取
         */
        System.out.println(blockingQueue.take());
    }

    /**
     *  new ArrayBlockingQueue(3);      offer       poll        返回 false / null
     */
    public static void arrayBlockingOfferPollDemo(){
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        /**
         * 当资源位已满的时候，继续添加
         *  返回 false
         */
        System.out.println(blockingQueue.offer("a"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        /**
         * 当资源位置已空的时候，继续移除
         * 返回 null
         */
        System.out.println(blockingQueue.poll());
    }

    /**
     *  new ArrayBlockingQueue<>(3);    add         remove      直接报错
     *      当资源满了，再继续添加的时候          java.lang.IllegalStateException: Queue full
     *      当资源已经为空的时候，继续 remove     java.util.NoSuchElementException
     *
     */
    public static void arrayBlockingQueueAddRemoveDemo(){
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("1"));
        System.out.println(blockingQueue.add("1"));
        System.out.println(blockingQueue.add("1"));
        /**
         * 当资源满了，再继续添加的时候
         *      java.lang.IllegalStateException: Queue full
         */
//        System.out.println(blockingQueue.add("1"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        /**
         * 当资源已经为空的时候，继续 remove
         *      java.util.NoSuchElementException
         */
//        System.out.println(blockingQueue.remove());

        /**
         * 获取首位元素
         */
        System.out.println(blockingQueue.element());

    }

    /**
     * 抢车位  new Semaphore(3);
     */
    public static void semaphoreDemo(){
        // 定义三个资源 ，3个空车位
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    // 抢占到了资源
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢占到了车位");
                    try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) {  e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName() + "\t 离开了车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    // 释放资源
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }

    /**
     *   new CyclicBarrier(7, () -> System.out.println("集齐七龙珠-----------------召唤神龙"));
     */
    public static void cyclicBarrierDemo(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println("-----------------召唤神龙"));
        for (int i = 0; i < 7; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t 获取到第：" + finalI + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }

    /**
     *   new CountDownLatch(10);    班长最后一个走
     */
    public static void countDownLunchDemo() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t 号同学离开教室");
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {  e.printStackTrace(); }
                // 计数减 1
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 班长关门走人");
    }

    /**
     * 获取多线程的四种方式
     *      （第 1 种：继承 Thread 类）
     *      （第 2 种：实现 Runnable 接口，无返回，不抛异常）
     *      （第 3 种：实现 Callable 接口，有返回）
     *      （第 4 种： 线程池 ThreadPoolDemo）
     *
     */
    public static void getThread() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyCache3());
        new Thread(futureTask,"Thread Name A").start();
        new Thread(futureTask,"Thread Name B").start();

        System.out.println(Thread.currentThread().getName() + "\t 计算完成");
        System.out.println(futureTask.get());
    }

    /**
     * HashMap不是线程安全的 ConcurrentHashMap
     *      错误信息：
     *          java.util.ConcurrentModificationException
     *      解决办法：
     *          new ConcurrentHashMap();
     */
    public static void hashMapNotSafe(){
        Map map = new HashMap();
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(()->{
                map.put(finalI,UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * HashSet不是线程安全的   Collections.synchronizedSet(new HashSet<>())    new CopyOnWriteArraySet();
     *
     *  错误信息
     *      java.util.ConcurrentModificationException
     *  解决办法
     *      Collections.synchronizedSet(new HashSet<>());
     *      new CopyOnWriteArraySet();
     *
     *
     *  HashSet 底层结构 hashMap
     *      构造一个新的空集合；HashMap 实例
     *      默认初始容量（16）和负载系数（0.75）。
     *  确定么？
     *      如果确定，则add的时候，怎么没有 key,value？
     *      确定！底层的 add 是执行的 map.put(e, PRESENT)
     *      e：是我们输入的值
     *          PRESENT： 是一个常量
     *          private static final Object PRESENT = new Object();
     */
    public static void hashSetNotSafe(){
        Set set = new HashSet();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    /**
     *  ArrayList不是线程安全的    Vector      Collections.synchronizedList(new ArrayList<>())     new CopyOnWriteArrayList<>()
     *      错误信息：
     *          java.util.ConcurrentModificationException
     *
     *      解决办法：
     *          1）使用 Vector
     *              缺陷： 加锁会影响并发性
     *          2）使用 Collections.synchronizedList(new ArrayList<>())
     *          3）使用 new CopyOnWriteArrayList<>()
     *              为什么：因为底层的加了 volatile
     *
     */
    public static void arrayListNotSafe(){
        List arrayList = new ArrayList();
        List copyOnWriteArrayList = new CopyOnWriteArrayList();
        List list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * 题目：多线程之间按顺序调用，实现 A -> B -> C
     *  AA 打印 5 次、BB 打印 10 次， CC 打印 15 次数
     *  ... 来 10 轮
     */
    public static void threadShare(){

        ShareResource shareResource = new ShareResource();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        },"Thread Name A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        },"Thread Name B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print15();
            }
        },"Thread Name C").start();

    }

    /**
     * 题目: 两个线程，操作初始值为零的一个变量，一个线程对该变量加 1 ，另一个线程对该变量减 1 。 交替来10轮
     *  变量初始值为 0
     *
     *          private Lock lock = new ReentrantLock();
     *          private Condition condition = lock.newCondition();
     *
     *          判断 / 干活 / 通知
     *              判断的时候只用 while  不用  if, 为了防止虚假唤醒
     *
     */
    public static void threadDemo(){

        AirConditioner airCondition = new AirConditioner();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    airCondition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread Name A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                    airCondition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread Name B").start();
    }

    /**
     * 读写锁  ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
     *  读 - 读 能共存
     *  读 - 写 不能共存
     *  写 - 写 不能共存
     */
    public static void readWrite(){
        Cache cache = new Cache();
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(()->{
                cache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                cache.get(finalI + "");
            }, String.valueOf(i)).start();
        }
    }

    /**
     *  lock / unLock    Lock lock = new ReentrantLock();
     */
    public static void saleTicket(){
        Ticket ticket = new Ticket();
        for (int i = 0; i < 31; i++) {
            new Thread(()->{
                ticket.saleTicket();
            }, String.valueOf(i)).start();
        }
    }
}
