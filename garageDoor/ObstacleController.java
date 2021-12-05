package FinalProject.garageDoor;


import FinalProject.garageDoor.command.ObstacleClearedCommand;
import FinalProject.garageDoor.command.ObstacleCommand;
import FinalProject.garageDoor.command.ObstacleDetectedCommand;
import FinalProject.garageDoor.sensor.Scheduler;

public class ObstacleController {
    private Scheduler scheduler;

    public ObstacleController(Scheduler scheduler) {
        this.scheduler = scheduler;
    }


    public void obstacleDetected() {
//        doorStatus.setObstacle(true);
        ObstacleCommand command = new ObstacleDetectedCommand();
        scheduler.addCommand(command);
    }

    public void obstacleCleared() {
//        doorStatus.setObstacle(true);
        ObstacleCommand command = new ObstacleClearedCommand();
        scheduler.addCommand(command);
    }

}
