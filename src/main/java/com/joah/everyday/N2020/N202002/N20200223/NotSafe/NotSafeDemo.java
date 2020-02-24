package com.joah.everyday.N2020.N202002.N20200223.NotSafe;

import com.sun.javafx.scene.control.skin.TableColumnHeader;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * 举例说明集合类是不安全的
 *
 *  1、故障现象
 *      java.util.ConcurrentModificationException
 *
 *  2、导致原因
 *
 *
 *  3、解决方案
 *      3.1、    Vector
 *      3.2、    Collections.synchronizedList(new ArrayList<>());
 *      3.3、    new CopyOnWriteArrayList<>();
 *
 *  4、优化建议
 *
 *
 *
 *
 *
 * @author Joah
 * @time 2020/2/23 16:38
 */
public class NotSafeDemo {

    public static void main(String[] args) {
        /**
         * HashMap底层是一个
         *      node类型的数组 + node类型的链表 + 红黑树
         *      默认长度
         *  HashMap     无序 、 无重复
         *
         *  ArrayList   有序、可重复
         *
         * Constructs an empty <tt>HashMap</tt> with the default initial capacity
         * (16) and the default load factor (0.75).
         *
         * new HashMap<>();
         * 等价于
         * new HashMap<>(16, 0.75f);
         *
         *
         */
        Map<String, String> mapHash = new HashMap<>(32,0.75f);
        Map<String, String> mapSyn = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }

    }

    public static void setNotSafe(){

        Set<String> setHash = new HashSet<>();

        Set<String> setSynchronize = Collections.synchronizedSet(new HashSet<>());

        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    /**
     *      3.3、    new CopyOnWriteArrayList<>();
     *          写时复制
     *          CopyOnWrite 容器即写时复制的容器，往一个容器添加元素的时候，不直接往当前容器Object[] 添加，
     *          而是先将当前容器Object[] 进行 Copy,复制出一个新的容器 Object[] newElements，然后新的容器 Object[] newElements里添加元素，
     *          添加完元素后，再将原容器的引用指向新的容器 setArray(newElements)；这样做的好处是可以对 CopyOnWrite 容器进行并发的读
     *          而不需要加锁，因为当前容器不会添加任何元素，
     *          所以 CopyOnWrite容器也是一种读写分离的思想，读和写用不同的容器
     *
     *          public boolean add(E e) {
     *              final ReentrantLock lock = this.lock;
     *              lock.lock();
     *              try {
     *                   Object[] elements = getArray();
     *                   int len = elements.length;
     *                   Object[] newElements = Arrays.copyOf(elements, len + 1);
     *                   newElements[len] = e;
     *                   setArray(newElements);
     *                   return true;
     *              } finally {
     *                  lock.unlock();
     *              }
     *          }
     */
    public static void listNotSafe(){
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
