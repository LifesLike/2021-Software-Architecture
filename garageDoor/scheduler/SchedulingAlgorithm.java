package FinalProject.garageDoor.scheduler;

import FinalProject.garageDoor.command.Command;

public interface SchedulingAlgorithm {

    abstract void addCommand(Command command);
    abstract Command getNextCommand();

}
