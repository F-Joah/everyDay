package com.joah.everyday.N2020.N202002.N20200229.JVM;


import lombok.Data;

/**
 * @author Joah
 * @time 2020/2/29 18:57
 */
@Data
public class Student02 {
    private Integer id;
    private String stuName;
    private Integer age;

    public String study(){

        return "ok";
    }

    public static void main(String[] args) {
        Student02 s1 = new Student02();
        Student02 s2 = new Student02();
        Student02 s3 = new Student02();

        // new 一个 800M 的大对象
        byte[] bytes = new byte[800 * 1024 * 1024];

    }
}
