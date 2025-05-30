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
            this.weatherTower = null;
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
                FtLogger.scenario("JetPlane", this.name, this.stringId,
                        "☀️ Blue skies and no turbulence — let's break the sound barrier for fun!");
            case RAIN ->
                FtLogger.scenario("JetPlane", this.name, this.stringId,
                        "🌧️ Rainy runways and lo-fi beats in the cockpit. Let's cruise above the clouds.");
            case FOG ->
                FtLogger.scenario("JetPlane", this.name, this.stringId,
                        "🌫️ Autopilot ON. Can't see squat but we're still flyin'.");
            case SNOW ->
                FtLogger.scenario("JetPlane", this.name, this.stringId,
                        "❄️ Engines cold, we keep calm and everything will be fine... right?");

        }
    }
}
