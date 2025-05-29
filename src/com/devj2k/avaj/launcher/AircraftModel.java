package com.devj2k.avaj.launcher;

import java.util.Arrays;
import java.util.List;

public record AircraftModel(String type, String name, String longitude, String latitude, String height) {
    // private String yo;
    private static final List<String> aircraftType = Arrays.asList("Helicopter", "Baloon", "JetPlane");

    public AircraftModel {
        if (!aircraftType.contains(type)) {
            throw new IllegalArgumentException(
                    "Aircraft type must be one of the following: " + String.join(", ", aircraftType));
        }
    }
}
