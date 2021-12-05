package FinalProject.garageDoor.sensor;

import FinalProject.garageDoor.command.Command;

public class Scheduler {
    SchedulingAlgorithm algorithm;

    public Scheduler() {
        algorithm = new PrioritySchedulingAlgorithm();
    }

    public void addCommand(Command command) {
        algorithm.addCommand(command);

    }
}
