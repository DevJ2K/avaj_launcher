package com.devj2k.avaj.launcher.utils;

import com.devj2k.avaj.launcher.FileManager;

public class FtLogger {

    private static final String TERMINAL_OUTPUT = System.getProperty("TERMINAL_OUT");
    public static final String OUTPUT_FILE = "simulation.txt";

    private FtLogger() {
    }

    public static boolean isTerminalOutput() {
        return TERMINAL_OUTPUT != null && TERMINAL_OUTPUT.toLowerCase().contentEquals("true");
    }

    public static void error(String description, Exception e) {
        System.out.print(Colors.to(Colors.RED, description + ": "));
        System.out.println(Colors.to(Colors.BRED, e.getMessage()));
    }

    public static void parsingError(String description, int line) {
        System.out.print(Colors.to(Colors.RED, "Parsing Error (line:" + line + "): "));
        System.out.println(Colors.to(Colors.BHRED, description));
    }

    public static void scenario(String aircraftType, String aircraftName, String id, String message) {
        if (!isTerminalOutput()) {
            FileManager.writeInFile(
                    OUTPUT_FILE,
                    aircraftType + "#" + aircraftName + "(" + id + "): " + message,
                    true);
        } else {
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
                    System.out.println(aircraftType + "#" + aircraftName + "(" + id + "): Unknown aircraft type");
            }
        }
    }

    public static void towerRegister(String aircraft) {
        if (!isTerminalOutput()) {
            FileManager.writeInFile(
                    OUTPUT_FILE,
                    "Tower says: " + aircraft + " registered to weather tower.",
                    true);
        } else {
            System.out.println(Colors.to(Colors.BWHITE,
                    "Tower says: " + Colors.to(Colors.BHWHITE, aircraft + " registered to weather tower.")));
        }
    }

    public static void towerUnregister(String aircraft) {
        if (!isTerminalOutput()) {
            FileManager.writeInFile(
                    OUTPUT_FILE,
                    "Tower says: " + aircraft + " unregistered from weather tower.",
                    true);
        } else {
            System.out.println(Colors.to(Colors.BWHITE,
                    "Tower says: " + Colors.to(Colors.BHWHITE, aircraft + " unregistered from weather tower.")));
        }
    }
}
