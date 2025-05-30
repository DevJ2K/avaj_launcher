package com.devj2k.avaj.launcher.utils;

public class FtLogger {

    private FtLogger() {
    }

    public static void error(String description, Exception e) {
        System.out.print(Colors.to(Colors.RED, description + ": "));
        System.out.println(Colors.to(Colors.BRED, e.getMessage()));
    }

    public static void parsingError(String description, int line) {
        System.out.print(Colors.to(Colors.RED, "Parsing Error (line:" + line + "): "));
        System.out.println(Colors.to(Colors.BHRED, description));
    }

    // Dans simulation.txt
    public static void scenario(String aircraftType, String aircraftName, String id, String message) {
        switch (aircraftType) {
            case "Baloon" ->
                System.out.println(Colors.to(Colors.BBLUE,
                        "Baloon#" + aircraftName + "(" + id + "): " + Colors.to(Colors.BHWHITE, message)));
            case "Helicopter" ->
                System.out.println(Colors.to(Colors.BMAG,
                        "Helicopter#" + aircraftName + "(" + id + "): " + Colors.to(Colors.BHWHITE, message)));
            case "JetPlane" ->
                System.out.println(Colors.to(Colors.BCYAN,
                        "JetPlane#" + aircraftName + "(" + id + "): " + Colors.to(Colors.BHWHITE, message)));
            default ->
                System.out.println("Unknown aircraft type: " + aircraftType + "#");
        }
    }

    // Dans simulation.txt
    public static void towerRegister(String aircraft) {
        System.out.println(Colors.to(Colors.BWHITE,
                "Tower says: " + Colors.to(Colors.BHWHITE, aircraft + " registred to weather tower.")));
    }

    public static void towerUnregister(String aircraft) {
        System.out.println(Colors.to(Colors.BWHITE,
                "Tower says: " + Colors.to(Colors.BHWHITE, aircraft + " unregistred from weather tower.")));
    }
}
