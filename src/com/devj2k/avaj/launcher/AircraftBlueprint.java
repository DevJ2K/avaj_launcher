package com.devj2k.avaj.launcher;

import java.util.Arrays;
import java.util.List;

public record AircraftBlueprint(String type, String name, int longitude, int latitude, int height) {
    // private String yo;
    private static final List<String> aircraftType = Arrays.asList("Helicopter", "Baloon", "JetPlane");

    public AircraftBlueprint {
        BeanValidation.validator()
        .validate(aircraftType.contains(type), "Aircraft type must be one of the following: " + String.join(", ", aircraftType))
        .validate(longitude >= 0, "Longitude must be non-negative")
        .validate(latitude >= 0, "Latitude must be non-negative")
        .validate(height >= 0 && height <= 100, "Height must be between 0 and 100")
        .validate(name != null && !name.isBlank(), "Name must not be null or empty")
        .validate(name.matches("[a-zA-Z0-9]+"), "Name must contain only alphanumeric characters")
        ;
    }
}
