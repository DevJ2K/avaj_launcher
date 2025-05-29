package com.devj2k.avaj.launcher;


public class AircraftFactory {
    private static int id = 1;
    private static final AircraftFactory aircraftFactory = new AircraftFactory();

    private AircraftFactory() {
    }

    private static AircraftFactory getInstance() {
        return aircraftFactory;
    }

    public Flyable newAircraft(String type, String name, Coordinates coordinates) {
        return switch(type) {
            case "Helicopter" -> new Helicopter(id++, name, coordinates);
            case "JetPlane" -> new JetPlane(id++, name, coordinates);
            case "Baloon" -> new Baloon(id++, name, coordinates);
            default -> null;
        };
    }

    public static void main(String[] args) {

        aircraftFactory.newAircraft("Helicopter", "B1", new Coordinates(0, 0, 0));
        aircraftFactory.newAircraft("JetPlane", "B1", new Coordinates(0, 0, 0));
        aircraftFactory.newAircraft("Baloon", "B1", new Coordinates(0, 0, 0));
        aircraftFactory.newAircraft("unknown", "B1", new Coordinates(0, 0, 0));

        System.out.println(aircraftFactory.id);

    }
}
