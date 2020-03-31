package com.neo.study.N20200318;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全的问题
 * @author Joah
 * @time 2020/3/18 21:53
 */
public class ContainerNotSageDemo {

    public static void main(String[] args) {

        Map<String, Object> map = new ConcurrentHashMap<>(); // new HashMap<>();

        /**
         * ConcurrentHashMap
         */
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }

    }

    public static void setNotSafe(){
        Set<String> set = new CopyOnWriteArraySet<>(); // new HashSet<>();
        /**
         * java.util.ConcurrentModificationException
         *
         * 解决办法：
         *  new CopyOnWriteArraySet<>();
         *
         */
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0, 8 ));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    public static void listNotSafe(){
        List<String> list =  new CopyOnWriteArrayList<>(); // Collections.synchronizedList(new ArrayList<>()); // new Vector<>(); // new ArrayList<>();

        /**
         * java.util.ConcurrentModificationException
         *      ArrayList 并发异常
         *
         * CopyOnWriteArrayList<>().add:
         *
         *          public boolean add(E e) {
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
        for (int i = 1; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }


}
