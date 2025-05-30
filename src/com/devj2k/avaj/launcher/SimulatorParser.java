package com.devj2k.avaj.launcher;

import com.devj2k.avaj.launcher.utils.FtLogger;
import java.util.List;
import java.util.Objects;


public class SimulatorParser {
    public static SimulationModel parse(String content) {
        if (Objects.isNull(content) || content.isBlank()) {
            FtLogger.parsingError("The file cannot be empty.");
        }
        List<String> lines = content.lines().toList();

        int i = 0;
        for (String line : lines) {
            if (line.isBlank()) {
                continue;
            }
            System.out.println(line);
        }

        return new SimulationModel(0, List.of());
    }
}
