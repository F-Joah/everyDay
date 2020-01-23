package com.joah.everyday.N2019.N201911.N20191127;

/**
 * 入住可以退房
 */
public class CheckInState implements State {

    Room hotelManagement;

    public CheckInState(Room hotelManagement){
        this.hotelManagement = hotelManagement;
    }

    @Override
    public void bookRoom() {
        System.out.println("该房间已经入住了");
    }

    @Override
    public void unsubscribeRoom() {
        System.out.println("该房间已经入住了");
    }

    @Override
    public void checkInRoom() {
        System.out.println("退房成功...");
        // 修改退房状态
        hotelManagement.setState(hotelManagement.getFreeTimeState());
    }

    @Override
    public void checkOutRoom() {
        // 不需要做操作
    }
}
