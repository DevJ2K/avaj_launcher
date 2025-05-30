package com.devj2k.avaj.launcher;

import com.devj2k.avaj.launcher.exception.BeanValidationException;
import com.devj2k.avaj.launcher.utils.FtLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SimulatorParser {
    public static Optional<SimulationData> parse(String content) {
        if (Objects.isNull(content) || content.isBlank()) {
            FtLogger.parsingError("The file cannot be empty.", 0);
        }
        List<String> lines = content.lines().toList();

        int numberOfSimulations = 0;
        List<AircraftBlueprint> aircraftBlueprints = new ArrayList<>();
        int i = 1;
        for (String line : lines) {
            if (line.isBlank()) {
                continue;
            }
            if (i == 1) {
                try {
                    numberOfSimulations = getInt(line);
                    if (numberOfSimulations < 0) {
                        FtLogger.parsingError("The number of simulations must be a positive integer.", i);
                        return Optional.empty();
                    }
                } catch (IllegalArgumentException e) {
                    FtLogger.parsingError("The first line must contain a valid integer for the number of simulations.",
                            i);
                    return Optional.empty();
                }
            } else {
                List<String> elements = List.of(line.split(" "));
                elements = elements.stream()
                        .filter(element -> !element.isBlank())
                        .map((elt) -> elt.strip())
                        .toList();

                if (elements.size() != 5) {
                    FtLogger.parsingError(
                            "Each aircraft line must contain exactly 5 elements. (TYPE(str) NAME(str) LONGITUDE(int) LATITUDE(int) HEIGHT(int))",
                            i);
                    return Optional.empty();
                }

                try {
                    AircraftBlueprint aircraftBlueprint = getAircraftBlueprint(elements);
                    aircraftBlueprints.add(aircraftBlueprint);
                } catch (IllegalArgumentException | BeanValidationException e) {
                    FtLogger.parsingError("Invalid aircraft blueprint: " + e.getMessage(), i);
                    return Optional.empty();
                }
            }
            i++;
        }
        return Optional.of(new SimulationData(numberOfSimulations, aircraftBlueprints));
    }

    private static AircraftBlueprint getAircraftBlueprint(List<String> elements) throws IllegalArgumentException {
        String type = elements.get(0);
        String name = elements.get(1);
        int longitude = getInt(elements.get(2));
        int latitude = getInt(elements.get(3));
        int height = getInt(elements.get(4));
        return new AircraftBlueprint(type, name, longitude, latitude, height);
    }

    private static int getInt(String line) throws IllegalArgumentException {
        try {
            return Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid integer value: " + line, e);
        }
    }
}
