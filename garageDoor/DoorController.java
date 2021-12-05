package FinalProject.garageDoor;

import FinalProject.garageDoor.actuator.ActuatorInterface;
import FinalProject.garageDoor.command.DoorCommand;
import FinalProject.garageDoor.command.DoorOpenCommand;
import FinalProject.garageDoor.sensor.Scheduler;

import java.util.Observable;
import java.util.Observer;

public class DoorController implements Observer {
    private Scheduler scheduler;
    private ActuatorInterface actuatorDriver;
    private DoorStatus doorStatus = DoorStatus.getInstance();
    private Observable observable;
    private boolean obstacle = false;

    public DoorController(Scheduler scheduler, ActuatorInterface actuatorDriver) {
        this.scheduler = scheduler;
        this.actuatorDriver = actuatorDriver;
        observable = doorStatus;
        observable.addObserver(this);
    }

    public void doorOpen() {
        if (obstacle) {
            System.out.println("장애물 때문에 문 열 수 없음");
            return;
        } else {
            System.out.println("문 열기 시작");
            DoorCommand command = new DoorOpenCommand(actuatorDriver);
            scheduler.addCommand(command);
        }
    }

    public void doorClose() {

    }

    public void doorStop() {

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof DoorStatus) {
            obstacle = ((DoorStatus) o).getObstacle();
        }
    }
}
