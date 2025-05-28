package com.devj2k.avaj.launcher;

import com.devj2k.avaj.launcher.utils.FtLogger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class Simulator {

    public static void main(String[] args) throws Exception {
        // if (args.length != 1) {
        // System.out.println("Usage: java Simulator <scenario_file>");
        // return;
        // }
        String filePath = "../avaj_launcher/scenario.txtr";

        Optional<String> optionalFileContent = Optional.ofNullable(getContentFromFile(filePath));
        if (optionalFileContent.isEmpty()) {
            return ;
        }
        String fileContent = optionalFileContent.get();
        System.out.println(fileContent);
    }

    private static String getContentFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            FtLogger.error("Error while reading file", e);
            return null;
        }
        return content.toString();
    }

    // private static String getContent(String filePath) {
    // try {
    // ClassLoader classLoader = Simulator.class.getClassLoader();
    // URL resource = classLoader.getResource(filePath);
    // if (resource == null) {
    // throw new FileNotFoundException("File not found: " + filePath);
    // }
    // File file = new File(resource.getFile());
    // byte[] content = Files.readAllBytes(file.toPath());
    // return new String(content);
    // } catch (IOException e) {
    // System.err.println("Error reading file: " + e.getMessage());
    // return null;
    // }
    // }
}
