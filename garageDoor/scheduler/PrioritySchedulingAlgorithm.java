package FinalProject.garageDoor.scheduler;

import FinalProject.garageDoor.command.Command;

import java.util.Collections;
import java.util.PriorityQueue;

public class PrioritySchedulingAlgorithm implements SchedulingAlgorithm {
    private PriorityQueue<Command> queue = new PriorityQueue<>(Collections.reverseOrder());

    @Override
    public void addCommand(Command command) {
        queue.add(command);
        Command nextCommand = getNextCommand();
        nextCommand.start();
    }

    @Override
    public Command getNextCommand() {
        return queue.poll();
    }
}
