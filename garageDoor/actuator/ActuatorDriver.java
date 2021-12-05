package FinalProject.garageDoor.actuator;

public class ActuatorDriver implements ActuatorInterface {

    ActuatorSimulator actuatorSimulator = new ActuatorSimulator();

    @Override
    public void up() {
        actuatorSimulator.setCommand("up");
    }

    @Override
    public void down() {
        actuatorSimulator.setCommand("down");
    }

    @Override
    public void stop() {
        actuatorSimulator.setCommand("halt");
    }
}
