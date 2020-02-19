package com.joah.everyday.N2020.N202002.N20200219;


import org.springframework.cache.CacheManager;

/**
 * @author Joah
 * @time 2020/2/19 9:34
 */
public class Test {

    /**
     * N-21 osi七层模型
     *  1、物理层
     *  2、数据链路层
     *  3、网络层
     *  4、传输层
     *  5、会话层
     *  6、表示层
     *  7、应用层
     */

    /**
     * N-22 线程和进程的区别
     *
     *  1、线程（Thread） 和 进程（Process）
     *      进程定义的是应用程序与应用程序之间的边界，通常来说，一个进程代表一个与之对应的应用程序。
     *       不同的进程之间不能共享代码和数据空间。
     *       而同一进程和不同的线程可以共享代码和数据空间
     *
     *  2、一个进程可以包括若干线程，同时创建多个线程来完成某项任务，便是多线程
     *
     *  3、实现线程的两种方式
     *     3.1、继承Thread类
     *     3.2、实现 Runnable 接口
     *
     *  4、使用java多线程类的方式
     *     4.1、线程池
     *     4.2、继承 Thread 类
     *     4.3、实现 Runnable 接口，无返回，不抛异常
     *     4.4、实现 Callable 接口，有返回
     *
     */

    /**
     * N-23、JVM的内存结构
     *
     *  java虚拟机的内存结构分为 堆（heap） 和 栈（stack），
     *      堆 里面存放的是对象实例，也就是 new 出来的对象
     *      栈 里面存放的是基本数据类型以及引用数据类型的地址
     *
     *  对于所谓的常量是存储在方法区的常量池里
     *
     */

    /**
     * N-24 内存泄露和内存溢出
     *
     *  内存泄露（memory leak）
     *      是指应用程序在申请内存后，无法释放已经申请的内存空间，
     *      一次内存泄露危害可以忽略
     *      如果任其发展最终会导致内存溢出（out of memory）
     *      如，读取文件后流要及时关闭一级对数据库连接的释放
     *
     *  内存溢出（out of memory）
     *      是指应用程序在申请内存时，没有足够的内存空间供其使用
     *      如我们在项目中对于大批量数据的导入，采用分段批量提交的方式
     *
     *
     */

    /**
     * N-25 单例
     *
     *  单例就是该类只返回一个实例
     *  单例锁具备的特点：
     *      1、私有化的构造函数
     *      2、私有的静态的全局变量
     *      3、共有的静态方法
     *
     *  单例分为
     *      懒汉式、
     *      饿汉式
     *      双层锁式
     *
     */

    /**
     * 饿汉式
     *
     */
    public class Sigleton1{

        private Sigleton1(){}

        private Sigleton1 sigleton = new Sigleton1();

        public Sigleton1 getInstance(){

            return sigleton;
        }
    }
    /**
     *  懒汉式
     *
     */
    public class Sigleton2{

        private Sigleton2(){}

        private Sigleton2 sigleton = null;

        public Sigleton2 getInstance(){

            if (sigleton == null) {
                sigleton = new Sigleton2();
            }
            return sigleton;
        }
    }

    /**
     * 线程安全
     *
     */
    public class Sigleton3{

        private Sigleton3(){}

        private Sigleton3 sigleton;

        public Sigleton3 getInstance(){
            if (null == sigleton){
                synchronized (Sigleton3.class){
                    if (null == sigleton){
                        sigleton = new Sigleton3();
                    }
                }
            }
            return sigleton;
        }
    }

    /**
     * N-26 解析xml文件的几种技术
     *
     *  1、解析 xml的几种技术
     *      1.1、dom4j
     *          dom4j 是一个 Java 的XML API,类似于jdom,用来读写xml文件的。
     *          dom4j 是一个非常优秀的Java XML API,具有性能优异，功能强大和极端易使用的特点
     *          同时它也是一个开放源代码的软件
     *
     *      1.2、sax
     *          SAX（simple Api for Xml）是一种XMl解析的替代方法，
     *          相比DOM，SAX是一种速度更快，更有效的方法。它朱行扫描文件，一边扫描一边解析。
     *          相比于DOM，SAX可以再解析文档的任意时刻停止解析，但任何事情都有其相反的一面，对于SAX来说就是操作复杂
     *
     *      1.3、jaxb
     *          JAXB（Java Architecture for XML Binding） 是一个业界标准，是一项可以根据XML Schema产生 java 类的技术。
     *          该过程中，JAXB 也提供了将 Xml 实例文档反向生成 Java对象树的方法，并能将 java对象树的内容重新写到 xml实例文档。
     *          从另一方面来讲，JAXB 提供了快速而简便的方法，将XML模式绑定到Java表示，从而使得Java开发者在Java应用程序中能方便的结合XML数据和处理函数
     *
     *      1.4、jdom
     *      1.5、dom
     *
     *  2、dom4j 和 sax 之间的对比****
     *
     *      dom4j 不适合大文件的解析，因为它是一下子将文件加载到内存中，所以有可能出现内存溢出
     *      sax 是基于事件来对 xml进行解析的，所以他可以解析大文件的 xml
     *
     *      dom4j可以对xml进行灵活的增删改查和导航，而sax没有这么强的灵活性
     *      所以 sax经常用来解析大型的xml文件，而要对xml文件进行一些灵活(crud)操作就用dom4j
     *
     */

    /**
     * N-27 项目的生命周期
     *
     *  1、需求分析
     *  2、概要设计
     *  3、详细设计（用例图、流程图、类图）
     *  4、数据库设计（powerDesigner）
     *  5、代码开发（编写）
     *  6、单元测试（Junit白盒测试）（开发人员）
     *      Git管理代码
     *  7、集成测试（黑盒测试、loadRunner（编写测试脚本）高级测试）
     *  8、上线运行（用户自己体验）
     *  9、压力测试（loadRunner）
     *  10、正式上线
     *  11、维护
     *
     */

    /**
     * N-32 Java Exception体系结构
     *
     *      java 异常是程序运行过程中出现的错误。
     *      Java把异常当做对象处理，并定义一个基类 java.lang.Throwable 作为所有异常的超类
     *      在 Java API中定义了许多异常类，分为两大类
     *          1、错误 Error
     *
     *              1.1、Error 是程序无法处理的错误，比如 OutOfMemoryError、ThreadDeath 等，这些异常发生时，Java虚拟机（JVM）一般会选择线程终止
     *
     *
     *          2、异常 Exception
     *              2.1、Exception 是程序本身可以处理的异常，这种异常分为两大类，程序中应当尽可能去处理这些异常
     *                  2.1.1、运行时异常 RuntimeException
     *                      IndexOutOfBoundsException 索引越界异常
     *                      ArithmeticException 数学计算异常
     *                      NullPointerException 空指针异常
     *                      ArrayOutOfBoundsException 数组索引越界异常
     *                      ClassNotFoundException 类文件未找到异常
     *                      ClassCastException 造型异常（类型转换异常）
     *
     *                      这些异常不检查异常（Unchecked Exception），程序中科院选择捕获处理，也可以不处理。这些异常一般是由程序逻辑错误引起的
     *
     *                  2.1.2、非运行时异常  非 RuntimeException
     *                      非运行时异常是 运行时异常 以外的异常，类型上都属于 Exception 类及其子类。
     *                      从程序语法角度讲是必须进行处理的异常，如果不处理，程序就不能编译通过
     *                      如：
     *                          IOException 文件读写异常
     *                          FileNotFoundException 文件未找到异常
     *                          EOFException 读写文件尾异常
     *                          MalformedURLException URL格式错误异常
     *                          SocketException Socket异常
     *                          SQLException SQL数据库异常
     *
     */



}
