package com.devj2k.avaj.launcher;

import com.devj2k.avaj.launcher.utils.FtLogger;

public class JetPlane extends Aircraft {

    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
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
            FtLogger.scenario("JetPlane", this.name, this.stringId, "landing.");
            this.weatherTower.unregister(this);
            FtLogger.towerUnregister("JetPlane#" + this.name + "(" + this.stringId + ")");
        } else {
            displayConditions();
        }
    }

    private void displayConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        if (currentWeather == null) {
            FtLogger.scenario("JetPlane", this.name, this.stringId, "has no weather data available.");
            return;
        }
        switch (WeatherType.valueOf(currentWeather)) {
            case SUN ->
                FtLogger.scenario("JetPlane", this.name, this.stringId, "Great day to do some flip close the sun !");
            case RAIN -> FtLogger.scenario("JetPlane", this.name, this.stringId,
                    "Let listen some PNL to match with the rain...");
            case FOG -> FtLogger.scenario("JetPlane", this.name, this.stringId, "Where, we are??");
            case SNOW -> FtLogger.scenario("JetPlane", this.name, this.stringId, "Yooo, this is too cold bro!!");
        }
    }
}
