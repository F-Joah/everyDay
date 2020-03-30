package N201911.N20191117.facade;

public class WatchTvSwtichFacade {

    Light light;
    AirCondition airCondition;
    Screen screen;
    Television television;

    public WatchTvSwtichFacade(Light light, AirCondition airCondition, Screen screen, Television television){
        this.light = light;
        this.airCondition = airCondition;
        this.screen = screen;
        this.television = television;
    }

    public void on(){
        // 先开灯
        light.on();
        // 打开空调
        airCondition.on();
        // 降下银幕
        screen.up();
        // 打开电视
        television.on();
    }

    public void off(){
        television.off();
        screen.down();
        airCondition.off();
        light.off();
    }

}
