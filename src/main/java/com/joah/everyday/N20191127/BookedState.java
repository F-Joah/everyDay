package com.joah.everyday.N20191127;

/**
 * 入住状态：房间只能退房
 */
public class BookedState implements State {

    Room hotelManagement;

    public BookedState(Room hotelManagement){
        this.hotelManagement = hotelManagement;
    }
    @Override
    public void bookRoom() {
        System.out.println("该房间已经预定了...");
    }

    @Override
    public void unsubscribeRoom() {
        System.out.println("退订成功，欢迎下次光临...");
        hotelManagement.setState(hotelManagement.getFreeTimeState());
    }

    @Override
    public void checkInRoom() {
        System.out.println("入住成功...");
        hotelManagement.setState(hotelManagement.getCheckInstate());
    }

    @Override
    public void checkOutRoom() {
        // 不需要做操作
    }
}
