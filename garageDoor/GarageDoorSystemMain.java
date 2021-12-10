package FinalProject.garageDoor;

import FinalProject.garageDoor.actuator.ActuatorDriver;
import FinalProject.garageDoor.actuator.ActuatorInterface;
import FinalProject.garageDoor.communication.Communication;
import FinalProject.garageDoor.scheduler.Scheduler;
import FinalProject.garageDoor.sensor.ObstacleSensorDriver;
import FinalProject.garageDoor.sensor.ObstacleSensorDriverInterface;

public class GarageDoorSystemMain {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        ActuatorInterface actuatorDriver = new ActuatorDriver();

        DoorController doorController = new DoorController(scheduler, actuatorDriver);
        ObstacleController obstacleController = new ObstacleController(scheduler, actuatorDriver);
        ObstacleSensorDriverInterface obstacleSensor = new ObstacleSensorDriver(obstacleController);

        Communication communication = new Communication(doorController);
        communication.connectServer();
    }
}
