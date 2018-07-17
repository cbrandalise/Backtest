package algorithm;

import data.Bar;
import data.Sides;
import event.Event;
import event.EventQueue;
import event.SignalEvent;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class SMAAlgo implements Algorithm {
    private EventQueue<Event> eventQueue;
    private boolean inPosition;

    public SMAAlgo(EventQueue<Event> eventQueue) {
        this.eventQueue = eventQueue;
        inPosition = false;
    }

    @Override
    public void initialize() {
        System.out.println("Initialized called");
    }

    @Override
    public void handleBarEvent(Bar bar) {
        if(bar.getClose() >= 1000 && !inPosition) {
            inPosition = true;
            System.out.println("LONG SIGNAL");
            System.out.println(bar.toString());
            this.eventQueue.pushEvent(new SignalEvent("TEST", Sides.LONG));
        }

        if(bar.getClose() <= 1000 && inPosition) {
            inPosition = false;
            System.out.println("SHORT SIGNAL");
            System.out.println(bar.toString());
            this.eventQueue.pushEvent(new SignalEvent("TEST", Sides.SHORT));
        }
    }

    @Override
    public void handleTickEvent() {

    }
}
