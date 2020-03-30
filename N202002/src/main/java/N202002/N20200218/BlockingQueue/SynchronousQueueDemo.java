package N202002.N20200218.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * *** SynchronousQueue:
 *      一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入一直处于阻塞状态
 *      与其他BlockingQueue不同，SynchronousQueue是一个不存储记录的BlockingQueue
 *      每个put操作必须要等待一个 take操作，否则不能继续添加元素，反之亦然
 *
 * @author Joah
 * @time 2020/2/18 13:05
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        /**
         * 生产者线程
         * 该线程不会立即执行生产，会等消费线程消费后才会再次生产
         */
        new Thread(() ->{
            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAAAA").start();

        // 消费者线程
        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println( Thread.currentThread().getName()+ "\t" +blockingQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println( Thread.currentThread().getName()+ "\t" +blockingQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println( Thread.currentThread().getName()+ "\t" +blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBBB").start();
    }
}
