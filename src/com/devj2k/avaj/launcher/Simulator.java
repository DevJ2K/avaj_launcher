package com.devj2k.avaj.launcher;

import java.util.Optional;

public class Simulator {

    public static void main(String[] args) throws Exception {
        // if (args.length != 1) {
        // System.out.println("Usage: java Simulator <scenario_file>");
        // return;
        // }
        String filePath = "../avaj_launcher/scenario.txt";

        Optional<String> optionalFileContent = Optional.ofNullable(FileManager.getContentFromFile(filePath));
        if (optionalFileContent.isEmpty()) {
            return ;
        }
        String fileContent = optionalFileContent.get();
        System.out.println(fileContent);
        // FileManager.writeInFile("simulation.txt", "Hello World !", true);
        SimulatorParser.parse(fileContent);
    }
}
