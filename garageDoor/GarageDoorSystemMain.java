package FinalProject.garageDoor;

import FinalProject.garageDoor.actuator.ActuatorDriver;
import FinalProject.garageDoor.actuator.ActuatorInterface;
import FinalProject.garageDoor.scheduler.Scheduler;

public class GarageDoorSystemMain {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        ActuatorInterface actuatorDriver = new ActuatorDriver();
        DoorController doorController = new DoorController(scheduler, actuatorDriver);
        Communication communication = new Communication(doorController);
        communication.connectServer();
    }
}
