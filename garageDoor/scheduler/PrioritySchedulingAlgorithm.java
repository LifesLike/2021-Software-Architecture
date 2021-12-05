package FinalProject.garageDoor.scheduler;

import FinalProject.garageDoor.command.Command;

import java.util.Collections;
import java.util.PriorityQueue;

public class PrioritySchedulingAlgorithm implements SchedulingAlgorithm {
    private PriorityQueue<Command> queue = new PriorityQueue<>(Collections.reverseOrder());

    //todo 커맨드 아직 실행중일 경우 다음 커맨드가 대기하도록 수정해야함
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
