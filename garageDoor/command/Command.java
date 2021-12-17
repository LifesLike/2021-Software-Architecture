package FinalProject.garageDoor.command;

public abstract class Command implements Comparable<Command> {
    int priority;

    public Command(int priority) {
        this.priority = priority;
    }

    public abstract void start();

    @Override
    public int compareTo(Command cmd) {
        return priority - cmd.priority;
    }
}
