package FinalProject.garageDoor.sensor;

import FinalProject.garageDoor.ObstacleController;

public class ObstacleSensorDriver implements ObstacleSensorDriverInterface {

    private final ObstacleController obstacleController;

    public ObstacleSensorDriver(ObstacleController obstacleController) {
        this.obstacleController = obstacleController;
    }

    @Override
    public void obstacleDetected() {
        obstacleController.obstacleDetected();
    }

    @Override
    public void obstacleCleared() {
        obstacleController.obstacleCleared();
    }
}
