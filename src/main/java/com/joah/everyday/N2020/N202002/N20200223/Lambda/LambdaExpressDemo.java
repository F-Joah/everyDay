package com.joah.everyday.N2020.N202002.N20200223.Lambda;


@FunctionalInterface
interface Foo{

    int add(int x, int y);

    default int div(int x, int y){
        System.out.println("------------------");
        return x / y;
    }

    static int mv(int x, int y){

        return x * y;
    }

}

/**
 *  1、Lambda Express
 *      1.1、口诀
 *          拷贝 小括号
 *          写死 小箭头
 *          落地 大括号
 *
 *      1.2、@FunctionalInterface
 *
 *      1.3、default
 *
 *      1.4、静态方法实现
 *
 *
 *
 *
 *
 * @author Joah
 * @time 2020/2/23 14:16
 */
public class LambdaExpressDemo {

    public static void main(String[] args) {

        /**
         * Foo foo = new Foo() {
         *             @Override
         *             public void sayHello() {
         *                 System.out.println("Say Hello");
         *             }
         *         };
         *         foo.sayHello();
         *
         */
        Foo foo = (x, y) ->{
            System.out.println("*******x + y = " + (x + y));
            return x + y;
        };
        System.out.println(foo.add(2, 5));

        System.out.println(foo.div(10, 5));

        System.out.println(Foo.mv(5, 2));

    }
}
