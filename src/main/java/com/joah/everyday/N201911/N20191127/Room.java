package com.joah.everyday.N201911.N20191127;

import lombok.Data;

/**
 * 房间类
 */
@Data
public class Room {
    /**
     * 房间的三个状态
     */
    // 空闲状态
    State freeTimeState;
    // 入住状态
    State checkInstate;
    // 预定状态
    State bookedState;

    State state;

    public Room(){
        freeTimeState = new FreeTimeState(this);
        checkInstate = new CheckInState(this);
        bookedState = new BookedState(this);

        state = freeTimeState;
    }

    /**
     * 预订房间
     */
    public void bookRoom(){
        state.bookRoom();
    }

    /**
     * 退订房间
     */
    public void unsubscribeRoom(){
        state.unsubscribeRoom();
    }

    /**
     * 入住
     */
    public void checkInRoom(){
        state.checkInRoom();
    }

    /**
     * 退房
     */
    public void checkOutRoom(){
        state.checkOutRoom();
    }

    @Override
    public String toString() {
        return "该房间的状态是：" + getState().getClass().getName();
    }
}
