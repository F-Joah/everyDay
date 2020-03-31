package com.neo.study.N20200318;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@Data
@ToString
@AllArgsConstructor
class User{
    private String id;
    private String name;
}

/**
 * 原子引用类型
 *
 * @author Joah
 * @time 2020/3/18 21:20
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference<>();

        User zs = new User("001","张三");
        User ls = new User("002","李四");

        atomicReference.set(zs);

        System.out.println(atomicReference.compareAndSet(zs, ls) + "\t " + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(zs, ls) + "\t " + atomicReference.get().toString());

    }
}
