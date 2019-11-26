package com.joah.everyday.N20191126.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject
{
    private List<Observer> observers;
    private float tempteratue;
    private float pressure;
    private float humidity;

    public WeatherData(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if ( i >= 0 ){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++){
            Observer observer = observers.get(i);
            observer.update(tempteratue, humidity, pressure);
        }
    }

    /**
     * 气象站得到更新的观测数据时，通知观察者
     */
    public void messurementChanged(){
        notifyObserver();
    }

    public void setMessurements(float tempteratue, float humidity, float pressure){
        this.tempteratue = tempteratue;
        this.humidity = humidity;
        this.pressure = pressure;
        messurementChanged();
    }
}
