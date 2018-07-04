package event;

import event.Event;

import java.util.ArrayList;

public class EventQueue<T extends Event> {
    private ArrayList<T> eventList = new ArrayList<>();

    public EventQueue(T event) {
        pushEvent(event);
    }

    public void pushEvent(T event) {
        eventList.add(event);
    }

    public boolean hasEvent() {
        return eventList.size() > 0;
    }

    public T popEvent() {
        if(hasEvent()) {
            T event = eventList.remove(0);
            return event;
        }

        return null;
    }
}
