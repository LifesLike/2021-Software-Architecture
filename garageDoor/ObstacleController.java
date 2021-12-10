package FinalProject.garageDoor;


import FinalProject.garageDoor.actuator.ActuatorInterface;
import FinalProject.garageDoor.command.ObstacleClearedCommand;
import FinalProject.garageDoor.command.ObstacleCommand;
import FinalProject.garageDoor.command.ObstacleDetectedCommand;
import FinalProject.garageDoor.scheduler.Scheduler;

public class ObstacleController {
    private Scheduler scheduler;
    private ActuatorInterface actuatorDriver;

    public ObstacleController(Scheduler scheduler, ActuatorInterface actuatorDriver) {
        this.scheduler = scheduler;
        this.actuatorDriver = actuatorDriver;
    }

    public void obstacleDetected() {
//        doorStatus.setObstacle(true);
        ObstacleCommand command = new ObstacleDetectedCommand(actuatorDriver);
        scheduler.addCommand(command);
    }

    public void obstacleCleared() {
//        doorStatus.setObstacle(true);
        ObstacleCommand command = new ObstacleClearedCommand();
        scheduler.addCommand(command);
    }

}
