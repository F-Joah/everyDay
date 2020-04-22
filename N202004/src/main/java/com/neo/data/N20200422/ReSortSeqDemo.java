package com.neo.data.N20200422;

/**
 * @author Joah
 * @time 2020/4/22 20:08
 */
public class ReSortSeqDemo
{
    int a = 0;
    boolean flag = false;

    public void method01()
    {
        // 语句 1
        a = 1;
        // 语句 2
        flag = true;
    }

    public void method02()
    {
        if (flag)
        {
            a = a + 5;
            System.out.println("************************** retValue:" + a);
        }
    }
}
