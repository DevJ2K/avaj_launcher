package com.devj2k.avaj.launcher;

import com.devj2k.avaj.launcher.utils.Colors;
import com.devj2k.avaj.launcher.utils.FtLogger;
import java.util.List;
import java.util.Optional;

public class Simulator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Simulator <scenario_file>");
            return;
        }

        Optional<String> optionalFileContent = Optional.ofNullable(FileManager.getContentFromFile(args[0]));
        if (optionalFileContent.isEmpty()) {
            return;
        }
        String fileContent = optionalFileContent.get();

        if (!FtLogger.isTerminalOutput() && !FileManager.writeInFile("simulation.txt", "", false)) {
            return ;
        }
        Optional<SimulationData> optionalSimulationData = SimulatorParser.parse(fileContent);
        optionalSimulationData.ifPresent(((simulationData) -> runSimulation(simulationData)));
    }

    public static void runSimulation(SimulationData simulationData) {
        System.out.println(
                Colors.to(Colors.BWHITE, "Running simulation with " + simulationData.repeat() + " simulations and "
                        + simulationData.aircraftBlueprints().size() + " aircraft blueprints."));

        AircraftFactory aircraftFactoryInstance = AircraftFactory.getInstance();
        List<Flyable> flyables = simulationData.aircraftBlueprints()
                .stream()
                .map(((aircraftBlueprint) -> aircraftFactoryInstance.newAircraft(
                        aircraftBlueprint.type(),
                        aircraftBlueprint.name(),
                        new Coordinates(aircraftBlueprint.longitude(), aircraftBlueprint.latitude(),
                                aircraftBlueprint.height()))))
                .toList();

        WeatherTower tower = new WeatherTower();

        if (flyables.size() != simulationData.aircraftBlueprints().size() || flyables.isEmpty()) {
            return;
        }

        for (int i = 0; i < flyables.size(); i++) {
            Flyable flyable = flyables.get(i);
            AircraftBlueprint aircraftBlueprint = simulationData.aircraftBlueprints().get(i);

            tower.register(flyable);
            flyable.registerTower(tower);

            FtLogger.towerRegister(aircraftBlueprint.type() + "#" + aircraftBlueprint.name() + "(" + (i + 1) + ")");
        }
        for (int i = 0; i < simulationData.repeat(); i++) {
            tower.changeWeather();
        }
        if (FtLogger.isTerminalOutput()) {
            System.out.println(
                Colors.to(Colors.BHGREEN, "Simulation completed."));
        } else {
            System.out.println(
                    Colors.to(Colors.BHGREEN, "Simulation completed. Check '" + FtLogger.OUTPUT_FILE + "' for details."));
        }
    }
}
