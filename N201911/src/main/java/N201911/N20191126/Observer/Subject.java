package N201911.N20191126.Observer;


/**
 * 主题接口
 */
public interface Subject {

    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 当主题状态发生变化时，这个方法需要被调用，以通知所有观察者
     */
    void notifyObserver();
}
