package com.devj2k.avaj.launcher;

import com.devj2k.avaj.launcher.utils.FtLogger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public static String getContentFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("line:" + line);
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            FtLogger.error("Error while reading in file '" + fileName + "'", e);
            return null;
        }
        return content.toString();
    }

    public static boolean writeInFile(String fileName, String content, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append))) {
            writer.append(content);
            if (append) {
                writer.append('\n');
            }
            return true;
        } catch (IOException e) {
            FtLogger.error("Error while writing in file '" + fileName + "'", e);
            return false;
        }
    }
}
