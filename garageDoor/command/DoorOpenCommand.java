package FinalProject.garageDoor.command;

import FinalProject.garageDoor.actuator.ActuatorInterface;

public class DoorOpenCommand extends DoorCommand {
    private ActuatorInterface actuatorDriver;

    public DoorOpenCommand(ActuatorInterface actuatorDriver) {
        this(actuatorDriver, 1);
    }

    public DoorOpenCommand(ActuatorInterface actuatorDriver, int priority) {
        super(priority);
        this.actuatorDriver = actuatorDriver;
    }

    @Override
    public void start() {
        actuatorDriver.up();
    }

}
