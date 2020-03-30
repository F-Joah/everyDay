package N201911.N20191126.Observer;

public class CurrentConditionsDisplay implements Observer,DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherDats;

    public CurrentConditionsDisplay(Subject weatherDats) {
        this.weatherDats = weatherDats;
        weatherDats.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("现状：" + temperature + "F 度，" + humidity +"% 湿度");
    }
}
