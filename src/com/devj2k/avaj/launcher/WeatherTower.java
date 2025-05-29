package com.devj2k.avaj.launcher;


public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        this.conditionChanged();
        for (Flyable flyable : this.observers) {
            flyable.updateConditions();
        }
    }
}
