package FinalProject.garageDoor.command;

import FinalProject.garageDoor.actuator.ActuatorInterface;

public class DoorCloseCommand extends DoorCommand{
    private ActuatorInterface actuatorDriver;

    public DoorCloseCommand(ActuatorInterface actuatorDriver) {
        this.actuatorDriver = actuatorDriver;
    }

    @Override
    public void start() {
        actuatorDriver.down();
    }
}
