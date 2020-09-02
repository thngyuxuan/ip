public class Event extends Task {
    protected String timings;
    public Event(String description, String timings) {
        super(description);
        this.timings = timings;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at:" + timings + ")";
    }
}
