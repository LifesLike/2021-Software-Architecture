package FinalProject.garageDoor.command;

public class ObstacleDetectedCommand extends ObstacleCommand {
    private projectTest.DoorStatus doorStatus = projectTest.DoorStatus.getInstance();

    private Thread thread;


    @Override
    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void cancel() {

    }

    @Override
    public void run() {

    }
}
