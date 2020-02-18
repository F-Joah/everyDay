package com.joah.everyday.N2020.N202002.N20200217.Lock;

import javafx.beans.value.ObservableObjectValue;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 资源类
 */
class MyCache{

    private volatile Map<String, Object> map = new HashMap<>();

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key,Object value){

        rwLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入: " + key);

            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成: ------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }

    }

    public void get(String key){

        rwLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取: " + key);
            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成: ----------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }
}

/**
 *
 *
 * 多个线程同时读一个资源类没有任何问题，所以，为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程想去写共享资源，就不应该再有其他线程可以对资源进行读或写
 *
 * 小总结：
 *      读 - 读 能共存
 *      读 - 写 不能共存
 *      写 - 写 不能共存
 *
 * 写操作：
 *      原子 + 独占 整个过程必须是一个完整的统一体，不允许被分割
 *
 *
 * @author Joah
 * @time 2020/2/17 14:35
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();

        // 正在写
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() ->{
                myCache.put(tempInt +"", tempInt+"");
            },String.valueOf(i)).start();

        }

        // 正在读
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() ->{
                myCache.get(tempInt +"");
            },String.valueOf(i)).start();

        }
    }
}
