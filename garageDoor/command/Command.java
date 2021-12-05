package FinalProject.garageDoor.command;

public abstract class Command implements Comparable<Command> {
    int priority;

    public abstract void start();

    @Override
    public int compareTo(Command cmd) {
        return cmd.priority - priority;
    }
}
