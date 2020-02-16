package com.joah.everyday.N2020.N202002.ContainerNotSafe问题;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全的问题
 *  ArrayList不是线程安全的
 *  HashSet不是线程安全的
 *
 * @author Joah
 * @time 2020/2/16 19:32
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        mapNotSafe();
    }

    public static void mapNotSafe(){
        Map<String,String> map = new ConcurrentHashMap<>(); //new HashMap<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(() ->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
        /**
         * 1、故障现象
         *      并发修改异常 java.util.ConcurrentModificationException
         *
         * 2、导致原因
         *
         * 3、解决方案
         *      1)使用new ConcurrentHashMap<>();
         *
         * 4、优化建议
         *
         *
         */
    }

    public static void listNotSafe(){
        /**
         * new 一个 ArrayList底层是数组  new 了一个 空的 list 初始值是 10
         * 超过 10  扩容
         * 扩容，扩容10 的 一半
         *
         * ArrayList是线程不安全的
         *
         */

        List<String> list = new CopyOnWriteArrayList<>();

        /**
         * 1、故障现象
         *      并发修改异常 java.util.ConcurrentModificationException
         *
         * 2、导致原因
         *      ArrayList是线程不安全的
         *      并发，争抢修改导致，参考签名例子:
         *          一个人，正在写，另一个人过来抢夺，导致数据不一致异常 即并发修改异常
         *
         * 3、解决方案
         *      1）使用 Vector
         *          缺陷： 加锁会影响并发性
         *      2）使用 Collections.synchronizedList(new ArrayList<>())
         *      3）使用 new CopyOnWriteArrayList<>()
         *          为什么：因为底层的加了 volatile
         *
         *
         * 4、优化建议
         *
         *
         */
        for (int i = 1; i <= 30; i++) {
            new Thread(() ->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

        /**
         * 写时复制
         *  CopyOnWrite 容器即写时复制的容器，往一个容器添加元素的时候，不直接往当前容器Object[]添加，
         *  而是先将当前容器 Object[]进行 copy,再将原容器的引用指向新的容器 setArray(newElements)
         *  这样做的好处是，可以对CopyOnWrite 容器进行分发的读
         *  而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写用不同 的容器
         *
         *      public boolean add(E e) {
         *         final ReentrantLock lock = this.lock;
         *         lock.lock();
         *         try {
         *             Object[] elements = getArray();
         *             int len = elements.length;
         *             Object[] newElements = Arrays.copyOf(elements, len + 1);
         *             newElements[len] = e;
         *             setArray(newElements);
         *             return true;
         *         } finally {
         *             lock.unlock();
         *         }
         *     }
         */
    }

    public static void setNotSafe(){
        Set<String> set = new CopyOnWriteArraySet<>(); //Collections.synchronizedSet( new HashSet<>());//new HashSet<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(() ->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }

        /**
         * HashSet 底层结构 hashMap
         *      构造一个新的空集合；HashMap 实例
         *      默认初始容量（16）和负载系数（0.75）。
         * 确定么？
         *      如果确定，则add的时候，怎么没有 key,value？
         *      确定！底层的 add 是执行的 map.put(e, PRESENT)
         *      e：是我们输入的值
         *      PRESENT： 是一个常量
         *      private static final Object PRESENT = new Object();
         */
        new HashSet<>();
    }
}
