package com.joah.everyday.N20191127;

public class FreeTimeState implements State {

    Room hotelManagement;

    public FreeTimeState(Room hotelManagement){
        this.hotelManagement = hotelManagement;
    }

    @Override
    public void bookRoom() {
        System.out.println("你已经成功预订了...");
        // 状态变更为已预订
        hotelManagement.setState(hotelManagement.getBookedState());
    }

    @Override
    public void unsubscribeRoom() {
        System.out.println("您已经成功入住了...");
        // 更改状态为已经入住
        hotelManagement.setState(hotelManagement.getCheckInstate());
    }

    @Override
    public void checkInRoom() {
        // 不做操作
    }

    @Override
    public void checkOutRoom() {
        // 不做操作
    }
}
