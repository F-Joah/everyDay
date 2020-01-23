package com.joah.everyday.N2019.N201911.N20191103;

public class Algorithm {

    public static void main(String[] args)
    {
        Algorithm demo = new Algorithm();
        // 斐波那契数列
//        demo.fibonacciSequence();
        // 素数问题
//        demo.primeNumber();
    }

    /**
     *  古典问题：
     *  有一对兔子，从出生后第3个月起每个月都生一对兔子，
     *  小兔子长到第三个月后每个月又生一对兔子，
     *  假如兔子都不死，问每个月的兔子总数为多少？
     */
    public void fibonacciSequence()
    {
        int fn1 = 1, fn2 = 1, fn;
        System.out.println("--->第1个月:"+(fn1 + fn2));
        System.out.println("--->第2个月:"+(fn1 + fn2));
        /**
         *  斐波那契数列：
         *  从第三项开始，后一项是前两项的和。
         *  1  1  2  3  5  8  13  21...
         */
        int M = 30;
        for (int i = 3; i < M; i++ )
        {
            fn = fn2;
            fn2 = fn1 + fn2;
            fn1 = fn;
            System.out.println("--->第" + i + "个月:" + fn2);
        }
    }

    /**
     *  判断101-200之间有多少个素数，并输出所有素数。
     */
    public void primeNumber()
    {
        int count = 0;
        /**
         * 素数：
         * 除了1和它本身以外不再有其他因数的自然数。
         * 除了2 其他的偶数，都不可能是素数，因为还有2是他的因数
         */
        for (int i = 101; i < 200; i+=2)
        {
            boolean flag = true;
            /**
             * Math.sqrt()
             * @一个数的算数平凡根
             * Math.sqrt(9) = 3
             *
             */
            for (int j = 2; j <= Math.sqrt(i); j++)
            {
                // 遍历寻找 i 是否有 1 和他本身之外的因数。如果有，break;
                if ( i % j == 0)
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
            {
                count++;
                System.out.println(i);
            }
        }
        System.out.println("素数的个数："+count);
    }

}
