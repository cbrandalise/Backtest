package event;

public abstract class Event {
    private EventTypes type;

    public Event(EventTypes type) {
        this.type = type;
    }

    public EventTypes getType() {
        return type;
    }
}
