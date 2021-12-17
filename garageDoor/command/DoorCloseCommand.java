package FinalProject.garageDoor.command;

import FinalProject.garageDoor.actuator.ActuatorInterface;

public class DoorCloseCommand extends DoorCommand{
    private ActuatorInterface actuatorDriver;

    public DoorCloseCommand(ActuatorInterface actuatorDriver) {
        this(actuatorDriver, 1);
    }

    public DoorCloseCommand(ActuatorInterface actuatorDriver, int priority) {
        super(priority);
        this.actuatorDriver = actuatorDriver;
    }

    @Override
    public void start() {
        actuatorDriver.down();
    }
}
