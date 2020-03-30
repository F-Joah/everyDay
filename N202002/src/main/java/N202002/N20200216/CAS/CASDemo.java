package N202002.N20200216.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Joah
 * @time 2020/2/16 14:43
 * 1、CAS是什么? =============> compareAndSet
 *      比较 并 交换。 比较当前工作内存中的值和主内存中的值，如果相同则执行规定操作，否则继续比较直到主内存和工作内存中的值一致为止
 *
 *      一条CPU并发原语
 *      功能:判断内存某个位置的值是否为预期值，如果是，则更改为新的值，这个过程是原子的
 *      底层实现：假设线程A 和线程 B 同时执行 getAndAddInt 操作（跑在不同的cpu上）
 *          1）AtomicInteger里面的value原始值是 3，即主内存中 AtomicInteger 的 value 为3，
 *          根据JMM模型，线程A 和 线程B 各自持有一份值为3的value的副本分贝到各自的工作内存
 *
 *          2）线程A通过 getIntVolatile(var1, var2) 拿到 value 值 3，这时线程A被挂起
 *
 *          3）线程B通过 getIntVolatile(var1, var2) 方法获取到Value值3，此时刚好线程B没有被挂起，并执行 compareAndSwapInt 方法
 *          比较内存值也为3，成功修改内存值为4，线程B 完成手工，一切Ok
 *
 *          4)这时线程A回复，执行 compareAndSwapInt 方法比较，发现自己手里的值数字 3 和主内存的值数字 4 不一样，说明该值
 *          已经被其他线程抢先一步修改过了，那A线程本次修改失败，只能重新读取重新来一遍
 *
 *          5）线程A 重新获取 value 值，因为变量 value 被 volatile 修饰，所以其他线程对它的修改，线程A 总是能够看到
 *          线程A 继续执行 compareAndSwapInt 进行比较替换，直到成功
 *
 *      CAS的应用
 *      CAS有三个操作数，内存值V,旧的预期值A,要修改的更新值B,
 *      当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做
 *
 *      CAS的缺点
 *          1、循环时间长，开销很大
 *          2、只能保证一个共享变量的原子操作
 *              1）对 多个共享变量操作的时候，循环CAS就无法保证操作的原子性，这个时候就可以用锁来保证原子性
 *          3、印出来ABA问题
 *
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        // CAS
        // main do someThing
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t current data:" + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data:" + atomicInteger.get());

        atomicInteger.getAndIncrement();
    }
}
