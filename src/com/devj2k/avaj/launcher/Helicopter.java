package com.devj2k.avaj.launcher;

import com.devj2k.avaj.launcher.utils.FtLogger;

public class Helicopter extends Aircraft {

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
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
            FtLogger.scenario("Helicopter", this.name, this.stringId, "landing.");
            this.weatherTower.unregister(this);
            this.weatherTower = null;
            FtLogger.towerUnregister("Helicopter#" + this.name + "(" + this.stringId + ")");
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
                FtLogger.scenario("Helicopter", this.name, this.stringId,
                        "☀️ Blades spinning, sun blazing — let's dance with the wind like it's Fortnite Christmas Season.");
            case RAIN ->
                FtLogger.scenario("Helicopter", this.name, this.stringId,
                        "🌧️ Rain's hitting the windshield like a beat drop. Time to hover in style.");
            case FOG ->
                FtLogger.scenario("Helicopter", this.name, this.stringId,
                        "🌫️ Can't see the ground... Hope GPS is feeling brave today.");
            case SNOW ->
                FtLogger.scenario("Helicopter", this.name, this.stringId,
                        "❄️ Ice on the rotors, and Ice in my vains. This ain't North Pole, but it's close!");

        }
    }
}
