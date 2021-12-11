package FinalProject.garageDoor.command;

import FinalProject.garageDoor.actuator.ActuatorInterface;

public class DoorStopCommand extends DoorCommand {
    private ActuatorInterface actuatorDriver;

    public DoorStopCommand(ActuatorInterface actuatorDriver) {
        this.actuatorDriver = actuatorDriver;
    }

    @Override
    public void start() {
        actuatorDriver.stop();
    }
}
