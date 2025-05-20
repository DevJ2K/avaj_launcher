package com.devj2k.avaj.launcher;


public class WeatherProvider {
    private String[] weather;
    private final WeatherProvider weatherProvider = new WeatherProvider();

    private WeatherProvider() {
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return "";
    }
}
