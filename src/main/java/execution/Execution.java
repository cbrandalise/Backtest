package execution;

import data.DataHandler;
import event.Event;
import event.EventQueue;
import event.OrderEvent;

public abstract class Execution {
    private EventQueue<Event> eventQueue;
    private DataHandler dataHandler;
    public Execution(EventQueue<Event> eventQueue, DataHandler dataHandler) {
        this.eventQueue = eventQueue;
        this.dataHandler = dataHandler;
    }

    public EventQueue<Event> getEventQueue() {
        return eventQueue;
    }

    public DataHandler getDataHandler() {
        return dataHandler;
    }

    public abstract void execute(OrderEvent event);
}
