package FinalProject.garageDoor.command;

import FinalProject.garageDoor.actuator.ActuatorInterface;

public class DoorOpenCommand extends DoorCommand {
    private Thread thread;
    private ActuatorInterface actuatorDriver;

    public DoorOpenCommand(ActuatorInterface actuatorDriver) {
        this.actuatorDriver = actuatorDriver;
    }

    @Override
    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void cancel() {
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
    }

    @Override
    public void run() {

    }
}
