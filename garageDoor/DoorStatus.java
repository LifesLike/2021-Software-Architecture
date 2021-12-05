package FinalProject.garageDoor;

import java.util.Observable;

public class DoorStatus extends Observable {
    private boolean obstacle;

    private static class InnerInstanceClass {
        private static final DoorStatus instance = new DoorStatus();
    }

    private void obstacleStatusChanged() {
        setChanged();
        notifyObservers();
    }

    public static DoorStatus getInstance() {
        return DoorStatus.InnerInstanceClass.instance;
    }

    public void setObstacle() {
        this.obstacle = true;
        obstacleStatusChanged();
    }

    public void clearObstacle() {
        this.obstacle = false;
        obstacleStatusChanged();
    }

    public boolean getObstacle() {
        return obstacle;
    }
}
