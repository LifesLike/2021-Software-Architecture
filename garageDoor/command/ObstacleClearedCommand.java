package FinalProject.garageDoor.command;

import FinalProject.garageDoor.DoorStatus;

public class ObstacleClearedCommand extends ObstacleCommand {
    private DoorStatus doorStatus = DoorStatus.getInstance();

    public ObstacleClearedCommand() {
        this(10);
    }

    public ObstacleClearedCommand(int priority) {
        super(priority);
    }

    @Override
    public void start() {
        doorStatus.clearObstacle();
    }

}
