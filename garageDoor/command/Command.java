package FinalProject.garageDoor.command;

public abstract class Command implements Comparable<Command>, Runnable {
    int priority;

    public abstract void start();
    public abstract void cancel();

    @Override
    public int compareTo(Command cmd) {
        return cmd.priority - priority;
    }
}
