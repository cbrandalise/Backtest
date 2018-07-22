package algorithm;

import data.Bar;
import event.Event;
import event.EventQueue;

public abstract class Algorithm {
    private EventQueue<Event> eventQueue;
    private boolean inPosition = false;

    public Algorithm(EventQueue<Event> eventQueue) {
        this.eventQueue = eventQueue;
    }

    public abstract void initialize();
    public abstract void handleBarEvent(Bar bar);
    public abstract void handleTickEvent();

    public EventQueue<Event> getEventQueue() {
        return eventQueue;
    }

    public void setInPosition(boolean inPosition) {
        this.inPosition = inPosition;
    }

    public boolean isInPosition() {
        return inPosition;
    }
}
