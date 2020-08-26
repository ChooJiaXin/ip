package duke.task;

/**
 * Represents a task with a description.
 */
public class Task {
    private String description;
    private boolean isDone;

    // Markers
    public static final String TICK = "[" + "\u2713" + "]";
    public static final String CROSS = "[" + "\u2718" + "]";

    /**
     * Creates a new task with the specified description.
     *
     * @param description Description of task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns a tick if the task is done. Otherwise, returns a cross.
     *
     * @return A tick if the task is done and a cross if the task is not done.
     */
    public String getStatusIcon() {
        return (isDone ? TICK : CROSS);
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Returns true if the task is done. Otherwise, returns false.
     *
     * @return true if the task is done and returns false if the task is not done.
     */
    public boolean hasDoneStatus() {
        return this.isDone;
    }

    /**
     * Returns a String representation of a task.
     *
     * @return String representation of a task.
     */
    @Override
    public String toString() {
        return this.getStatusIcon() + " " + this.description;
    }
}
