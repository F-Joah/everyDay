package com.joah.everyday.N2020.N202002.N20200218;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Joah
 * @time 2020/2/18 9:35
 */
public class Test {
    /**
     * N-11、Page 和 PageContext的区别
     *  1）Page是 servlet 对象，使用 this 关键字，作用域范围是同一页面
     *  2）PageContext是作用域通信对象，通常使用setAttribute() 和 getAttribute()来设置和获取
     *
     */

    /**
     * N-12、Ajax总结
     *  1)Ajax全称：异步JavaScript 及 xml（Asynchronous JavaScript And XML）
     *  Ajax 的核心是 JavaScript对象 XmlHttpRequest(XHR)
     *
     *  2)Ajax的优点：
     *      (1)、提高用户体验度（UE）
     *      (2)、提高应用程序的性能
     *      (3)、进行局部刷新
     *
     *  3）AJAX不是一种新的变成语言，而是一种创建更好更快以及交互性更强的web应用程序的技术
     *
     *  4）通过Ajax，我们的JavaScript可以使用JavaScript的XMLHttpRequest对象来直接与服务器进行通信
     *      通过这个对象，我们的JavaScript可在不重载页面的情况与 web服务器交换数据，即可局部刷新
     *
     *  5）Ajax在浏览器与Web服务器之间使用异步传输（HTTP请求），这样就可使网页服务器请求少量的信息，而不是整个页面
     *  减轻服务器负担，提升站点性能，Ajax可使因特网应用程序更小、更快、更友好、用户体验更好
     *
     *  6）Ajax是基于标准化并被广泛支持的技术，并且不需要插件和下载小程序
     *
     */

    /**
     *
     * N-13、JSP 9大隐式对象中四个作用域的大小与作用范围
     *  1）四大作用域从大到小：application > session > request > page
     *      application：全局作用范围，整个应用程序共享
     *                  生命周期为：应用程序启动到停止
     *      session:会话作用域，当用户首次访问时，产生一个新的会话，以后服务器就可以记住这个会话状态
     *      request:请求作用域，就是客户端的一次请求
     *      page:一个jsp页面
     *
     *  2）以上作用域范围越来越小，request和page的生命周期都是短暂的
     *      他们的区别就是：一个 request 可以包含多个 page页面
     */

    /**
     *
     * N-14、List、Set、Collection、Collections
     *  1) List 和 Set都是接口，他们都继承于接口 Collection，
     *      List 是一个有序的可重复的集合
     *      Set  是无需的不可重复的集合
     *      Collection 是集合的顶层接口
     *      Collections 是一个封装了众多关于集合方法的工具类，因为构造方法是私有的，所以不能实例化
     *  2）List接口实现类有 ArrayList、LinkedList、Vector
     *      ArrayList和Vector是【基于数组实现的】，
     *          所以查询的时候速度快，
     *          而在增删的时候速度慢
     *      LinkedList是基于链表存储结构，
     *          所以在进行查询的时候速度较慢，
     *          但在进行增加和删除的时候速度较快
     *      又因为Vector是****线程安全的，所以他和ArrayList相比而言，查询效率要低
     */

    public static void N14(String[] args) {
        /**
         * 并没有锁
         * boolean add(E e)
         */
        List<String> list = new ArrayList<>();
        list.add("");
        /**
         * 底层加了 synchronized 锁
         * public synchronized boolean add(E e)
         */
        Vector<String> vector = new Vector<>();
        vector.add("");


    }

    /**
     * N-15、Java的基本数据类型
     *  数据类型                    大小
     *      byte(字节)            1(8位)
     *      short(短整型)         2(16位)
     *      char(字符型)          2(16位)
     *      int(整形)             4(32位)
     *      long(长整型)          8(32位)
     *      float(浮点型)         4(32位)
     *      double(双精度)        8(64位)
     *      boolean(布尔型)       1位
     *
     */

    /**
     * N-16、冒泡排序
     *
     */
    public static int[] sort(){
        Scanner input = new Scanner(System.in);
        int sort[] = new int[10];
        int temp;

        System.out.println("请输入10个排序的数据!");
        for (int i = 0; i < sort.length; i++) {
            sort[i] = input.nextInt();
        }

        for (int i = 0; i < sort.length - 1; i++) {
            for (int j = 0; j < sort.length - i - 1; j++) {
                if (sort[j] < sort[j + 1]){
                    temp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = temp;
                }
            }
        }
        System.out.println("排序后的顺序为：");
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i] + "  ");
        }

        return sort;
    }


    /**
     * N-17、二分查找法
     *
     * 如果大型的数组中查询数据，可以使用二分法，也成为折半法
     *  1、使用二分法的时候，只能针对排序好的数组，
     *  2、数组中不能用重复的数据
     *
     * @param arr   排好序的数据
     * @param key   要查找的某个数据
     */
    public static void arry2(int[] arr,int key ){

        // 定义一个变量指向数组的最后一个元素
        int start = 0;
        int end = arr.length - 1;

        boolean flag = false;
        int middle = -1;
        while (start <= end){
            middle = (start + end) / 2;
            if (arr[middle] == key){
                flag = true;
                break;
            }
            // 例如，我们需要中 18，但是 arr[middle] 是 14
            else if (arr[middle] < key){
                start = middle + 1;
            }
            // 我们需要中 18 但是 arr[middle]是 19
            else {
                end = middle - 1;
            }
        }

        if (flag){
            System.out.println("找到数据，索引是：" + middle);
        }else {
            System.out.println("没有找到数据");
        }
    }


    /**
     * N-18、时间类型转换
     */
    public static void dateFun(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String newDate = null;
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            newDate = sdf.format(new SimpleDateFormat("yyyyMMdd").parse(format));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("当前日期：" + newDate);
    }

    /**
     * N-19、阶乘
     * @param num
     * @return
     */
    public static int multiply(int num){
        if (num < 0){
            System.out.println("请输入大于0的数！");
            throw new NullPointerException();
        }else if (num == 0 || num == 1){
            return 1;
        }else {
            return multiply(num - 1) * num;
        }
    }
    public static void main(String[] args) {
        int multiply = multiply(3);
        System.out.println("3的阶乘是：" + multiply);
    }

    /**
     * N-20、UE 和 UI的区别
     *
     *  1）UE 是用户体验度
     *  2）UI 界面原型（用户界面，相当于买房时的模型）
     *
     *  设计 UI 的作用：
     *      1、帮助程序猿工作（界面已由美工设计完成）
     *      2、提前让用户对项目又宏观的了解，知道效果是什么样子
     *
     */
}
