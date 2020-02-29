package com.joah.everyday.N2020.N202002.N20200229.JVM;

import java.util.Random;

/**
 *
 *  VM options
 *      -Xms1024m -Xmx1024m -XX:+PrintGCDetails
 *
 * @author Joah
 * @time 2020/2/29 14:56
 */
public class JVMDemo {

    public static void main(String[] args) {
        // 返回 Java 虚拟机试图使用的最大的内存量
        long max = Runtime.getRuntime().maxMemory();
        // 返回 Java 虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();

        /**
         * MAX_MEMORY:1029177344（字节）、981.5MB
         * TOTAL_MEMORY:1029177344（字节）、981.5MB
         *
         * PSYoungGen total 305664K + ParOldGen total 699392K = 981.5MB
         *
         *
         * Heap
         *  PSYoungGen      total 305664K, used 26214K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
         *   eden space 262144K, 10% used [0x00000000eab00000,0x00000000ec499be8,0x00000000fab00000)
         *   from space 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
         *   to   space 43520K, 0% used [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000)
         *  ParOldGen       total 699392K, used 0K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
         *   object space 699392K, 0% used [0x00000000c0000000,0x00000000c0000000,0x00000000eab00000)
         *  Metaspace       used 3225K, capacity 4556K, committed 4864K, reserved 1056768K
         *   class space    used 342K, capacity 392K, committed 512K, reserved 1048576K
         */
        System.out.println("MAX_MEMORY:" + max + "（字节）、" + (max / (double) 1024 / 1024) + "MB");
        System.out.println("TOTAL_MEMORY:" + totalMemory + "（字节）、" + (totalMemory / (double) 1024 / 1024) + "MB");

        /**
         *      [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 3874K->3857K(5632K)] 3874K->3857K(7680K), [Metaspace: 3240K->3240K(1056768K)], 0.0081943 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
         *
         *      Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
         */
        String str = "www.fancy-n.com";
        while (true){
            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999);
        }
    }

    public static void test(){
        JVMDemo jvmDemo = new JVMDemo();

        System.out.println(jvmDemo.getClass().getClassLoader().getParent().getParent());
        System.out.println(jvmDemo.getClass().getClassLoader().getParent());
        System.out.println(jvmDemo.getClass().getClassLoader());
    }
}
