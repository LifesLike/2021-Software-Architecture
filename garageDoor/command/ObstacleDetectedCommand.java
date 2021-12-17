package FinalProject.garageDoor.command;

import FinalProject.garageDoor.DoorStatus;
import FinalProject.garageDoor.actuator.ActuatorInterface;

public class ObstacleDetectedCommand extends ObstacleCommand {
    private DoorStatus doorStatus = DoorStatus.getInstance();
    private ActuatorInterface actuatorDriver;

    public ObstacleDetectedCommand(ActuatorInterface actuatorDriver) {
        this(actuatorDriver, 10);
    }

    public ObstacleDetectedCommand(ActuatorInterface actuatorDriver, int priority) {
        super(priority);
        this.actuatorDriver = actuatorDriver;
    }

    @Override
    public void start() {
        actuatorDriver.stop();
        doorStatus.setObstacle();
    }

}
