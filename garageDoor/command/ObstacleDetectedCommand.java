package FinalProject.garageDoor.command;

import FinalProject.garageDoor.DoorStatus;

public class ObstacleDetectedCommand extends ObstacleCommand {
    private DoorStatus doorStatus = DoorStatus.getInstance();


    @Override
    public void start() {
        doorStatus.setObstacle();
    }

}
