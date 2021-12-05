package FinalProject.garageDoor.command;

import FinalProject.garageDoor.actuator.ActuatorInterface;

public class DoorOpenCommand extends DoorCommand {
    private ActuatorInterface actuatorDriver;

    public DoorOpenCommand(ActuatorInterface actuatorDriver) {
        this.actuatorDriver = actuatorDriver;
    }

    @Override
    public void start() {
        actuatorDriver.up();
    }

}
