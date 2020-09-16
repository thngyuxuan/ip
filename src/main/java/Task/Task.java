package Task;

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

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "]" + this.description;
    }
    public Boolean isDone() {
        return this.isDone;
    }
    public abstract String toStringToSave();
}
