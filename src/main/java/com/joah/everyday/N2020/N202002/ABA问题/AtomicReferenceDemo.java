package com.joah.everyday.N2020.N202002.ABA问题;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.lang.ref.Reference;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@ToString
@AllArgsConstructor
class User{

    String userName;
    int age;
}

/**
 * 原子引用
 * @author Joah
 * @time 2020/2/16 18:20
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {

        User zs = new User("zs",22);
        User ls = new User("ls",25);

        AtomicReference<User> atomicUser = new AtomicReference<>();
        atomicUser.set(zs);

        // 张三 变 李四
        System.out.println(atomicUser.compareAndSet(zs, ls) + "\t " + atomicUser.get().toString());
        System.out.println(atomicUser.compareAndSet(zs, ls) + "\t " + atomicUser.get().toString());

    }
}
