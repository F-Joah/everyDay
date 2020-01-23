package com.joah.everyday.N2019.N201911.N20191127;

/**
 *
 */
public class Client{

    public static void main(String[] args) {
        // 默认有三间房
        Room[] rooms = new Room[3];
        // 初始化
        for (int i = 0; i < rooms.length; i++){
            rooms[i] = new Room();
        }
        // 第一间房
        // 预定
        rooms[0].bookRoom();
        // 入住
        rooms[0].checkInRoom();
        // 预定
        rooms[0].bookRoom();
        System.out.println(rooms[0]);
        System.out.println("---------------------------->>>>>>>>>>>>>>>");

        // 第二间房
        rooms[1].checkInRoom();
        rooms[1].bookRoom();
        rooms[1].checkOutRoom();
        rooms[1].bookRoom();
        System.out.println(rooms[1]);
    }
}