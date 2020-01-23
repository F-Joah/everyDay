package com.joah.everyday.N2019.N201911.N20191115.adapter;

public class BioRobot implements Robot {

    @Override
    public void cry() {
        System.out.println("仿生机器人叫:...");
    }

    @Override
    public void move() {
        System.out.println("仿生机器人慢慢移动:...");
    }
}
