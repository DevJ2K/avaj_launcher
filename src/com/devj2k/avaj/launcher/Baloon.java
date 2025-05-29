package com.devj2k.avaj.launcher;

import com.devj2k.avaj.launcher.utils.FtLogger;

public class Baloon extends Aircraft {

    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() throws IllegalArgumentException {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        if (currentWeather == null) {
            FtLogger.scenario("Baloon", this.name, this.stringId, "has no weather data available.");
            return;
        }
        switch (WeatherType.valueOf(currentWeather)) {
            case SUN:
                this.coordinates.setHeight(coordinates.getHeight() + 4);
                this.coordinates.setLongitude(coordinates.getLongitude() + 2);
            case RAIN:
                this.coordinates.setHeight(coordinates.getHeight() - 5);
            case FOG:
                this.coordinates.setHeight(coordinates.getHeight() - 3);
            case SNOW:
                this.coordinates.setHeight(coordinates.getHeight() - 15);
        }
        if (this.coordinates.getHeight() == 0) {
            FtLogger.scenario("Baloon", this.name, this.stringId, "has landed.");
            this.weatherTower.unregister(this);
        }
    }
}
