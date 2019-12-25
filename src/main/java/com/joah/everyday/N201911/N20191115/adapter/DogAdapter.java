package com.joah.everyday.N201911.N20191115.adapter;

public class DogAdapter implements Robot {

    Dog dog;

    /**
     * 取得适配器对象的引用
     * @param dog
     */
    public DogAdapter(Dog dog){
        this.dog = dog;
    }

    /**
     * 实现接口中的方法，只需要在相应的方法间进行转换即可完成
     */
    @Override
    public void cry() {
        System.out.println("机器人模拟狗叫...");
    }

    @Override
    public void move() {
        System.out.println("机器人模拟狗跑... ");
    }
}
