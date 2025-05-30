package com.devj2k.avaj.launcher;

public class AircraftFactory {
    private static int id = 1;
    private static final AircraftFactory aircraftFactory = new AircraftFactory();

    private AircraftFactory() {
    }

    public static AircraftFactory getInstance() {
        return aircraftFactory;
    }

    public Flyable newAircraft(String type, String name, Coordinates coordinates) {
        return switch (type) {
            case "Helicopter" -> new Helicopter(id++, name, coordinates);
            case "JetPlane" -> new JetPlane(id++, name, coordinates);
            case "Baloon" -> new Baloon(id++, name, coordinates);
            default -> null;
        };
    }
}
