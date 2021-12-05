package FinalProject.garageDoor.command;

import FinalProject.garageDoor.DoorStatus;

public class ObstacleClearedCommand extends ObstacleCommand {
    private DoorStatus doorStatus = DoorStatus.getInstance();

    @Override
    public void start() {
        doorStatus.clearObstacle();
    }

}
