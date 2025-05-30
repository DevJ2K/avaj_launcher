package com.devj2k.avaj.launcher;

import com.devj2k.avaj.launcher.utils.FtLogger;

public class Baloon extends Aircraft {

    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
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
            FtLogger.scenario("Baloon", this.name, this.stringId, "landing.");
            this.weatherTower.unregister(this);
            this.weatherTower = null;
            FtLogger.towerUnregister("Baloon#" + this.name + "(" + this.stringId + ")");
        } else {
            displayConditions();
        }
    }

    private void displayConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        if (currentWeather == null) {
            FtLogger.scenario("Helicopter", this.name, this.stringId, "has no weather data available.");
            return;
        }
        switch (WeatherType.valueOf(currentWeather)) {
            case SUN ->
                FtLogger.scenario("Baloon", this.name, this.stringId,
                        "☀️ Floating like a dream. Perfect day for a sky picnic!");
            case RAIN ->
                FtLogger.scenario("Baloon", this.name, this.stringId,
                        "🌧️ Uh-oh… balloons and rain don't mix. Where's my umbrella??");
            case FOG ->
                FtLogger.scenario("Baloon", this.name, this.stringId,
                        "🌫️ It's like drifting through a giant marshmallow… kinda spooky tho.");
            case SNOW ->
                FtLogger.scenario("Baloon", this.name, this.stringId,
                        "❄️ Snowflakes on the basket… it's magical, but my toes are frozen.");

        }
    }
}
