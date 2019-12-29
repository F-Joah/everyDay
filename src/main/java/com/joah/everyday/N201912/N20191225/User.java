package com.joah.everyday.N201912.N20191225;

import lombok.Data;

import java.io.Serializable;

/**
 * 支持序列化
 */
@Data
public class User implements Serializable{

    private Integer id;
    private String name;
    private Integer age;

    public User(){

    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
