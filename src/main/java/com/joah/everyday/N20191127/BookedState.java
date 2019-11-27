package com.joah.everyday.N20191127;

public class BookedState implements State {

    Room hotelManagement;

    public BookedState(Room hotelManagement){
        this.hotelManagement = hotelManagement;
    }
    @Override
    public void bookRoom() {

    }

    @Override
    public void unsubscribeRoom() {

    }

    @Override
    public void checkInRoom() {

    }

    @Override
    public void checkOutRoom() {

    }
}
