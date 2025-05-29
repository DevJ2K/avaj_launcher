package com.devj2k.avaj.launcher;


public class WeatherProvider {
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static final WeatherProvider weatherProvider = new WeatherProvider();

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int value = coordinates.getLongitude() * 10 + coordinates.getLatitude() * 1000 + coordinates.getHeight() * 100000;
        return weather[value % 4];
    }

    public static void main(String[] args) {
        System.out.println(WeatherProvider.getInstance().getCurrentWeather(new Coordinates(1, 1, 0)));
        System.out.println(WeatherProvider.getInstance().getCurrentWeather(new Coordinates(0, 1, 1)));
    }
}
