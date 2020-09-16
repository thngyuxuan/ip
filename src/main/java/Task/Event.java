package Task;

public class Event extends Task {
    protected String timings;
    public Event(String description, String timings) {
        super(description);
        this.timings = timings;
    }

    public String getType() {
        return "E";
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at:" + timings + ")";
    }

    public String toStringToSave() {
        return description + "/at" + timings;
    }
}
