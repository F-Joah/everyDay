package com.joah.everyday.N20191115.adapter;

public class Client {

    public static void main(String[] args) {
        // 一个机器人
        BioRobot robot = new BioRobot();
        // 一只狗
        Dog dog = new Dog();

        // 将狗狗包装进机器人中，使其像机器人
        Robot dogRobot = new DogAdapter(dog);


        // 然后是机器人 叫 和 跑
        System.out.println("BioRobot Cry ... ");
        dogRobot.cry();
        dogRobot.move();

        System.out.println("---------------------------------------");


    }

}
