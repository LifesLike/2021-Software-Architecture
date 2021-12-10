package FinalProject.garageDoor.command;

import FinalProject.garageDoor.DoorStatus;
import FinalProject.garageDoor.actuator.ActuatorInterface;

public class ObstacleDetectedCommand extends ObstacleCommand {
    private DoorStatus doorStatus = DoorStatus.getInstance();
    private ActuatorInterface actuatorDriver;

    public ObstacleDetectedCommand(ActuatorInterface actuatorDriver) {
        this.actuatorDriver = actuatorDriver;
    }

    @Override
    public void start() {
        actuatorDriver.stop();
        doorStatus.setObstacle();
    }

}
