package com.devj2k.avaj.launcher;

import com.devj2k.avaj.launcher.utils.FtLogger;


public class Helicopter extends Aircraft {

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

        public void updateConditions() throws IllegalArgumentException {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        if (currentWeather == null) {
            FtLogger.scenario("Helicopter", this.name, this.stringId, "has no weather data available.");
            return;
        }
        switch (WeatherType.valueOf(currentWeather)) {
            case SUN:
                this.coordinates.setHeight(coordinates.getHeight() + 2);
                this.coordinates.setLongitude(coordinates.getLongitude() + 10);
            case RAIN:
                this.coordinates.setLongitude(coordinates.getLongitude() + 5);
            case FOG:
                this.coordinates.setLongitude(coordinates.getLongitude() + 1);
            case SNOW:
                this.coordinates.setHeight(coordinates.getHeight() - 12);
        }
        if (this.coordinates.getHeight() == 0) {
            FtLogger.scenario("Helicopter", this.name, this.stringId, "has landed.");
        }
    }
}
