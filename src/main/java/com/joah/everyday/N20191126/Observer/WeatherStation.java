package com.joah.everyday.N20191126.Observer;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMessurements(80, 65, 30.4f);
        weatherData.setMessurements(50, 45, 25.2f);
        weatherData.setMessurements(60, 53, 32.6f);
    }
}
