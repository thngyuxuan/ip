/**
 * Class to hold the 'Task' objects.
 * Each object holds a String 'description', a Boolean 'isDone'
 * Contains other functions such as getters.
 */
package task;

public abstract class Task {
    protected String description;
    public Boolean isDone = false;

    public Task(String description) {
        this.description = description;
    }

    public String getStatusIcon() {
        return (this.isDone ? "\u2713" : "\u2718");
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public abstract String getType();

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "]" + this.description;
    }

    public abstract String toStringToSave();
}
