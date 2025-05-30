package com.devj2k.avaj.launcher;

import java.util.Random;

public class WeatherProvider {
    private final String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };
    private static final WeatherProvider weatherProvider = new WeatherProvider();

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int value = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) * 10;
        value = new Random().nextInt(value);
        return weather[value % 4];
    }
}
