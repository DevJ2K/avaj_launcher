package com.devj2k.avaj.launcher;

import java.util.Arrays;
import java.util.List;

public record AircraftBlueprint(String type, String name, int longitude, int latitude, int height) {
    // private String yo;
    private static final List<String> aircraftType = Arrays.asList("Helicopter", "Baloon", "JetPlane");

    public AircraftBlueprint {
        if (!aircraftType.contains(type)) {
            throw new IllegalArgumentException(
                    "Aircraft type must be one of the following: " + String.join(", ", aircraftType));
        }
    }
}
