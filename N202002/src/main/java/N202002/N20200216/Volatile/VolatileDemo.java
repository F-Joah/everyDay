package N202002.N20200216.Volatile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Joah
 * @time 2020/2/16 11:29
 */

class MyData{

    /**
     * 共享变量初始值
     */
    volatile int number = 0;

    public void addTo60(){
        this.number = 60;
    }

    /**
     * 此时 number 加了 volatile / 没加 synchronized 不保证原子性
     */
    public void addPlusPluss(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1、验证 volatile 的可见性
 *  1.1、加入int number = 0; number变量之前没有添加volatile关键字修饰
 *  1.2、添加了 volatile 可以解决可见性问题
 *      Jvm运行程序的实体是线程，而每一个线程创建时JVM都会为其创建一个工作内存（栈空间）
 *      工作内存，是每一个线程的私有数据区域，而java内存模型中规定所有变量都存储在主内存，主内存是共享内存区域，所有线程都可以访问
 *      但线程对变量的操作（读取赋值等）必须在工作内存中进行，首先要将变量从主内存拷贝到自己的工作内存空间，
 *      然后对变量进行操作，操作完成后，再将变量写回主内存
 *      不能直接操作主内存的变量，各个线程的过年工作内存中存储着主内存中的 ---变量副本拷贝---
 *      因此，不同 多线程无法访问对方的工作内存，线程间的通信（传值）必须通过主内存完成
 * 2、验证 volatile 不保证原子性
 *  2.1、原子性指什么?
 *      不可分割，完整性，即某个线程正在做某个具体业务时，中间不可被加塞或者分割，需要整体完整
 *      要么同事成功，要么同时失败
 *  2.2、volatile 不保证原子性验证
 *  2.3、why
 *  2.4、如何解决原子性？
 *      * 加sync
 *      * 使用atomicInteger
 */
public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();

        // 创建20 个线程
        for (int i = 1; i <= 20; i++) {
            new Thread(() ->{
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPluss();
                    myData.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }

        // 需要等待上面 20 个线程都结束后，再用main线程取得的结果是多少
        // 暂停线程
        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t int finally number value :" + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t atomicInteger finally number value :" + myData.atomicInteger);

    }

    /**
     *  volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
     */
    public static void seeOkByVolatile(){
        // 资源类别
        MyData myData = new MyData();

        // 第一个线程  AAA
        new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "\t come in");
            // 暂停线程
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value:" + myData.number);
        },"AAA").start();

        // 第二个线程 就是main线程
        while (myData.number == 0){
            // main线程就一直在等待循环，直到 number 不再等于零
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over,main get dataNumber：" + myData.number);
    }
}
