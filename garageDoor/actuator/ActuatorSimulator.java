package FinalProject.garageDoor.actuator;

public class ActuatorSimulator implements Runnable {

    private int curHeight = 0;
    private final int maxHeight = 300;
    private Thread thread = null;
    private String command;

    public void setCommand(String command) {
        this.command = command;
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
        thread = new Thread(this);
        thread.start();
    }

    public void up() {
        while (curHeight < maxHeight) {
            try {
                System.out.println("현재 문 높이: " + curHeight + " cm");
                curHeight += 1;
                Thread.sleep(30);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void down() {
        while (curHeight > 0) {
            try {
                curHeight -= 1;
                System.out.println("현재 문 높이: " + curHeight + " cm");
                Thread.sleep(30);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void halt() {
        System.out.println("현재 문 높이: " + curHeight + " cm");
    }

    @Override
    public void run() {
        if (command.equals("up")) {
            up();
        } else if (command.equals("down")) {
            down();
        } else {
            halt();
        }
    }
}
