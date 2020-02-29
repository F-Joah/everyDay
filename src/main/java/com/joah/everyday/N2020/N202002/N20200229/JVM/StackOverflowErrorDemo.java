package com.joah.everyday.N2020.N202002.N20200229.JVM;

/**
 *      Error extends Throwable
 *          VirtualMachineError extends Error
 *              StackOverflowError extends VirtualMachineError
 *                  Exception in thread "main" java.lang.StackOverflowError
 *
 *
 * @author Joah
 * @time 2020/2/29 18:04
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        StackOverflowError stackOverflowError = new StackOverflowError();
        test1();
    }

    private static void test1() {
        test1();
        System.out.println("*********hello ");
    }
}
