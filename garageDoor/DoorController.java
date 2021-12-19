package FinalProject.garageDoor;

import FinalProject.garageDoor.actuator.ActuatorInterface;
import FinalProject.garageDoor.command.DoorCloseCommand;
import FinalProject.garageDoor.command.DoorCommand;
import FinalProject.garageDoor.command.DoorOpenCommand;
import FinalProject.garageDoor.command.DoorStopCommand;
import FinalProject.garageDoor.scheduler.Scheduler;

import java.util.Observable;
import java.util.Observer;

public class DoorController implements Observer {
    private final Scheduler scheduler;
    private final ActuatorInterface actuatorDriver;
    private final DoorStatus doorStatus = DoorStatus.getInstance();
    private boolean obstacle = false;

    public DoorController(Scheduler scheduler, ActuatorInterface actuatorDriver) {
        this.scheduler = scheduler;
        this.actuatorDriver = actuatorDriver;
        doorStatus.addObserver(this);
    }

    public void doorOpen() {
        System.out.println("문 열기 시작");
        DoorCommand command = new DoorOpenCommand(actuatorDriver);
        scheduler.addCommand(command);
    }

    public void doorClose() {
        if (obstacle) {
            System.out.println("장애물 때문에 문 닫을 수 없음");
        } else {
            System.out.println("문 닫기 시작");
            DoorCommand command = new DoorCloseCommand(actuatorDriver);
            scheduler.addCommand(command);
        }
    }

    public void doorStop() {
        System.out.println("문 멈추기 시작");
        DoorCommand command = new DoorStopCommand(actuatorDriver);
        scheduler.addCommand(command);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof DoorStatus) {
            obstacle = ((DoorStatus) o).getObstacle();
        }
    }
}
