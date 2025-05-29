package com.devj2k.avaj.launcher.utils;

public class FtLogger {

    private FtLogger() {}

    public static void error(String description, Exception e) {
        System.out.print(Colors.to(Colors.RED, description + ": "));
        System.out.println(Colors.to(Colors.BRED, e.getMessage()));
    }

    public static void scenario(String aircraftType, String aircraftName, String id, String message) {
        switch (aircraftType) {
            case "Baloon":
                System.out.println(Colors.to(Colors.BBLUE, "Baloon#" + aircraftName + "(" + id + "): " + Colors.to(Colors.BHWHITE, message)));
            case "Helicopter":
                System.out.println(Colors.to(Colors.BMAG, "Helicopter#" + aircraftName + "(" + id + "): " + Colors.to(Colors.BHWHITE, message)));
            case "JetPlane":
                System.out.println(Colors.to(Colors.BCYAN, "JetPlane#" + aircraftName + "(" + id + "): " + Colors.to(Colors.BHWHITE, message)));
            default:
                System.out.println("Unknown aircraft type: " + aircraftType);
        }
    }

    public static void tower(String message) {
        System.out.println(Colors.to(Colors.BWHITE, "Tower says: " + Colors.to(Colors.BHWHITE, message)));
    }
}
