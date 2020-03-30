package N202002.N20200221;

/**
 * @author Joah
 * @time 2020/2/21 9:50
 */
public class Test {


    /**
     * N-33 session 和 cookie 的区别
     *
     *  1、session 是存储在服务器端
     *      cookie是存储在客户端的
     *      session 的 安全性 要高于 cookie，获取 session里的信息是通过存放在会话 cookie 里的 sessionid 获取的
     *      由于 session 是存放在服务器的内存中， 所以 session里的东西不断增加会造成服务器的负担，
     *      所以会把很重要的信息存储在 session中 而把一些次要东西存储在客户端的 cookie 里，
     *      然后 cookie 确切的说分为两大类分为 会话 cookie 和 持久化 cookie，会话cookie确切的说是存放客户端浏览器的内存中
     *      所以说他的生命周期和浏览器是一致的，浏览器关了 会话cookie也就消失了，
     *      然而持久化cookie是存放在客户端硬盘中，而持久化 cookie的生命周期就是我们设置 cookie时候设置的那个保存时间，
     *
     *      当浏览器关闭时 session 会不会丢失？
     *          从上述叙述分析，session的信息是通过 sessionid 获取的，而 sessionid 是存放在会话 cookie当中的，
     *          当浏览器关闭的时候 会话cookie 消失所以我们的 sessionid也就消失了，但是session的信息还存在服务器端
     *          这时我们只是查不到所谓的 session 但它并不是不存在。
     *          那么, session 在什么情况下丢失？
     *          就是在服务器关闭的时候，或者 session 过期，再或者调用了 invalidate() 或者是
     *          我们想要 session 中的某一条数据消失,调用session.removeAttribute()方法，
     *          然后session 在什么时候被创建呢？
     *          确切的说是通过调用 session.getSession 来创建，这就是 session 和 cookie 的区别
     *
     */

    /**
     * N-34 字节流 与 字符流 的区别
     *
     * stream 结尾都是字节流，reader 和 writer 结尾都是字符流
     * 两者区别就是读写的时候一个是按字节读写，一个是按字符读写
     * 实际使用通常差不多
     *
     * 在读写文件需要对内容按行处理，比如比较特定字符，处理某一行数据的时候一般会选择字符流
     * 只是读写文件，和文件内容无关的，一般选择字节流
     *
     */

    /**
     * N-35 final, finally, finalize 三者区别
     *
     * Final 是一个修饰符:
     *
     *  当 final 修饰一个变量的时候，变量变成一个常量，它不能被二次赋值
     *  当 final 修饰的变量为静态变量（即static修饰）时，必须在声明这个变量的时候给它赋值
     *  当 final 修饰方法时，该方法不能被重写
     *  当 final 修饰类时，该类不能被继承
     *  final 不能修饰抽象类，因为抽象类中会有需要子类实现的抽象方法，
     *      抽象类中可以有抽象方法，也可以有普通方法，当一个抽象类中没有抽象方法时，这个抽象类也就没有了它存在的必要
     *  final 不能修饰接口，因为接口中有需要其实现类来实现方法
     *
     * Finally:
     *
     *  finally只能与 try/catch 语句结合使用，finally语句块中的语句一定会执行，并且会在 return, continue, break关键字之前执行
     *
     * Finalize:
     *
     *  finalize 是一个方法，属于 java.lang.Object 类，finalize() 方法时 GC（garbage collector 垃圾回收） 运行机制的一部分
     *  finalize() 方法是在 GC清理它所丛书的对象时被调用的
     *
     */

    /**
     * N-36 IO流的层次结构
     *
     * 从流的方向
     *  输入流     输出流
     *
     * 从流的类型上
     * 字符流      字节流
     *
     * inputStream 和 outputStream 都是抽象类
     *
     * 它们下面的实现包括
     *      FileInputStream, BufferedInputStream
     *      FileOutputStream, BufferedOutputStream
     *
     * reader 和 writer
     *
     *  FileReader, BufferedReader, StringReader
     *  FileWriter, BufferedWriter, StringWriter, PrintWriter
     *
     */

    /**
     * N-37 JAVA
     *
     *      Java 是面相对象的，跨平台的，它通过Java虚拟机来进行跨平台操作，它可以进行自动垃圾回收的【 C语言 是通过人工进行来及回收的】
     *      Java 还会进行自动分配内存。【c语言是通过制定进行分配内存的】
     *          只需要new 一个对象，这个对象占用了多少空间，不需要我们来管，Java虚拟机负责管这些，
     *          用完之后也不需要我们来释放，Java虚拟机会自动释放
     *
     */

    /**
     * N-38 JavaSE  JavaEE  JavaME 区别
     *
     *  Java SE
     *      Java Standard Edition = j2se = Java 标准版
     *      SE注意用于桌面程序(swing)，控制平台(main 程序)
     *      Java SE(Java Platform,Standard Edition,Java标准版)就是基于JDK 和 JRE的
     *      Java SE 为 JavaEE 提供了基础
     *
     *  Java EE
     *      Java Enterprise Edition = j2ee = Java 企业版
     *      EE企业级开发(JSP, EJB, SpringMVC, Struts, hibernate, ibatis等)
     *      Java EE除了基于我们这个所谓的 Java SE 外，还新加了企业应用所需的类库
     *
     *  Java ME
     *      Java Mobile Edition = j2me = Java 移动版
     *      ME嵌入式开发（手机，小家电，PDA）【苹果的IOS，黑莓】
     *
     */

    /**
     * N-39 JDK JRE JVM的区别
     *
     *      JDK（Java Development ToolKit） 就是 Java 开发工具箱, JDK 是整个 Java 的核心，里面包含 JRE ，
     *  它除了包含JRE之外，还包含了一些 Javac 的工具类，把Java 源文件编译成 class 文件，Java文件是用来运行这个程序的，
     *  除此之外，里面还包含了Java原生的API ，java.lang.integer 在 rt的 jar包里面【可以在项目中看到】，通过rt这个jar包来调用我们的这些io流写入写出等
     *
     *      JDK 有一下三种版本：
     *
     *      J2SE, standard edition,标准版，是我们通常用的一个版本
     *      J2EE, enterpsise edition， 企业版，使用这种JDK开发 J2EE 应用程序
     *      J2ME, micro edition, 主要用于移动设备、嵌入式设备上的java 应用程序
     *
     *      Jre【Java Runtime Enviromental】 是Java 运行时环境，那么所谓的Java 运行时环境，就是为了保证Java程序能够运行时，所必备的一基础环境
     *      也就是它只是保证Java 程序运行的，不能用来开发，而JDK才是用来开发的，所有的 Java 程序都要在 JRE下才能运行
     *      包括 JVM 和JAVA 核心类库和支持文件，与 JDK相比，它不包含开发工具-----编译器、调试器和其他工具
     *
     *      Jre里包含JVM
     *      JVM【Java Virtual Mechinal】 因为jre 是 java 运行时环境，java 运行靠什么运行，而底层就是依赖于Jvm, 即 Java虚拟机，
     *      Java 虚拟机用来加载类文件，Java中之所以有跨平台的作用，就是因为我们的JVM
     *
     *      关系：
     *          J2SE 是基于 JDK 和 JRE
     *          JDK 是整个Java 的核心里边包含了 JRE
     *          JRE 里边包含JVM
     *
     */

    /**
     * N-40 错误的状态码
     *
     *  301 永久重定向
     *
     *  302 临时重定向
     *
     *  304 服务端 未改变
     *
     *  403 访问无权限
     *
     *  404 访问路径不存在
     *
     *  500 内部错误
     *
     */

    /**
     *
     * N-41 协议以及默认的端口号
     *
     *  ftp     21      文件传输协议
     *
     *  pop3    110     它是因特网 <http://baike.baidu.com/view/1706.html>
     *                      电子邮件 <http://baike.baidu.com/view/1524.html> 的第一个离线
     *                      <http://baike.baidu.com/view/113466.html> 协议标准
     *
     *  Smtp    25      简单邮件传输协议
     *
     *  http    80      超文本传输协议
     *
     *  oracle  默认端口号 1521
     *  mysql   默认端口号 3306
     *
     */

    /**
     * N-42 抽象类 与 接口 的区别
     *
     *  1、一个类只能进行单继承，但可以实现多个接口
     *
     *  2、有抽象方法的类一定是抽象类，但是抽象类里面不一定有抽象方法；
     *
     *  3、接口里面所有方法的默认修饰符为 public abstract，接口里的成员变量默认是修饰符为 public static final
     *
     *  4、关系
     *      接口和接口         继承关系
     *      接口和抽象类       抽象类实现接口
     *      类和抽象类         类继承抽象类
     *      类和类             继承关系
     *
     */

    /**
     * N-43、修饰符的作用
     *
     *  修饰符的作用范围
     *
     *  ----------------------------------------------------------------------------------------
     *                          private             default         protected           public
     *  ----------------------------------------------------------------------------------------
     *  同一个类中               可以                  可以              可以              可以
     *  ----------------------------------------------------------------------------------------
     *  同一个包的类中                                 可以              可以              可以
     *  ----------------------------------------------------------------------------------------
     *  不同包的子类中                                                   可以              可以
     *  ----------------------------------------------------------------------------------------
     *  不同包的类中                                                                       可以
     *  ----------------------------------------------------------------------------------------
     *
     */

    /**
     * N-44 onready 和 onload 的区别
     *
     *  1、onready 比 onload 先执行
     *  2、onready 是在页面解析完成之后执行，而 onload 是在页面所有元素加载后执行
     *  3、onload 只执行最后一个而 onready可以执行多个
     *
     *  4、执行时间
     *              window.onload 必须等到页面内包括图片的所有元素加载完毕后才能执行。
     *              $(document).ready() 是 DOM 结构回执完毕后就执行，不必等到加载完毕
     *  5、编写个数
     *              window.onload 不能同时编写多个，如果有多个 window.onload 方法
     *              只会执行一个 $(document).ready()可以同时编写多个，并且都可以得到执行
     *  6、简化写法
     *              window.onload 没有简化写法
     *              $(document).ready(function(){}) 可以简写成 $(function(){})
     *
     */

}
