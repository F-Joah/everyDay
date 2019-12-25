package com.joah.everyday.N201911.N20191117.facade;

public class Client {

    public static void main(String[] args) {
        // 实例化组件
        Light light = new Light();
        Television television = new Television();
        AirCondition airCondition = new AirCondition();
        Screen screen = new Screen();

        WatchTvSwtichFacade watchTvSwtichFacade = new WatchTvSwtichFacade(light,airCondition,screen,television);

        watchTvSwtichFacade.on();
        System.out.println("-------------------------------");
        watchTvSwtichFacade.off();
        System.out.println("-------------------------------");

    }
}
