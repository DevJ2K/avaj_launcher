package com.devj2k.avaj.launcher.utils;

public class FtLogger {

    private FtLogger() {}

    public static void error(String description, Exception e) {
        System.out.print(Colors.to(Colors.RED, description + ": "));
        System.out.println(Colors.to(Colors.BRED, e.getMessage()));
    }
}
