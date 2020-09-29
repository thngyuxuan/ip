package task;

public class Event extends Task {
    protected String timing;
    public Event(String description, String timings) {
        super(description);
        this.timing = timings;
    }

    public String getType() {
        return "E";
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at:" + timing + ")";
    }

    public String toStringToSave() {
        return description + "/at" + timing;
    }
}
