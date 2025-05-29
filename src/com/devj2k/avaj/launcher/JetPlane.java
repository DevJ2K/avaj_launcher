package com.devj2k.avaj.launcher;

import com.devj2k.avaj.launcher.utils.FtLogger;

public class JetPlane extends Aircraft {

    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() throws IllegalArgumentException {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        if (currentWeather == null) {
            FtLogger.scenario("JetPlane", this.name, this.stringId, "has no weather data available.");
            return;
        }
        switch (WeatherType.valueOf(currentWeather)) {
            case SUN:
                this.coordinates.setHeight(coordinates.getHeight() + 2);
                this.coordinates.setLatitude(coordinates.getLatitude() + 10);
            case RAIN:
                this.coordinates.setLatitude(coordinates.getLatitude() + 5);
            case FOG:
                this.coordinates.setLatitude(coordinates.getLatitude() + 1);
            case SNOW:
                this.coordinates.setHeight(coordinates.getHeight() - 7);
        }
        if (this.coordinates.getHeight() == 0) {
            FtLogger.scenario("JetPlane", this.name, this.stringId, "has landed.");
            this.weatherTower.unregister(this);
        }
    }
}
