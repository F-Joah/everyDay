package N201911.N20191127;

/**
 * 状态接口
 */
public interface State {

    /**
     * 预定房间
     */
    void bookRoom();

    /**
     * 退订房间
     */
    void unsubscribeRoom();

    /**
     * 入住
     */
    void checkInRoom();

    /**
     * 退房
     */
    void checkOutRoom();
}
