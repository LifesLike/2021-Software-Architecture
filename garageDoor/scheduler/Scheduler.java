package FinalProject.garageDoor.scheduler;

import FinalProject.garageDoor.command.Command;

public class Scheduler {
    SchedulingAlgorithm algorithm;

    public Scheduler(SchedulingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void addCommand(Command command) {
        algorithm.addCommand(command);

    }
}
