package com.joah.everyday.N20191121.interpreter;

public class Client {

    public static void main(String[] args) {
        String statement = "3 * 2 * 4 / 4 * 2 % 7";
        Calculator calculator = new Calculator();
        calculator.build(statement);
        int result = calculator.compute();
        System.out.println(statement + " = " + result);
    }
}
