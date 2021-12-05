package FinalProject.garageDoor.actuator;

public class ActuatorSimulator implements Runnable {

    private int curHeight = 0;
    private int maxHeight = 200;
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
                System.out.println("현재 문 높이: " + curHeight);
                curHeight += 10;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void down() {
        while (curHeight > 0) {
            try {
                curHeight -= 10;
                System.out.println("현재 문 높이: " + curHeight);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void halt() {
        System.out.println("현재 문 높이: " + curHeight);
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
