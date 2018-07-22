package algorithm;

import data.Bar;
import data.Sides;
import event.Event;
import event.EventQueue;
import event.SignalEvent;

public class SMAAlgo extends Algorithm {

    public SMAAlgo(EventQueue<Event> eventQueue) {
        super(eventQueue);
    }

    @Override
    public void initialize() {
        System.out.println("Initialized called");
    }

    @Override
    public void handleBarEvent(Bar bar) {
        if(bar.getClose() >= 1000 && !this.isInPosition()) {
            this.setInPosition(true);
            this.getEventQueue().pushEvent(new SignalEvent("TEST", Sides.LONG));
        }

        if(bar.getClose() <= 1000 && this.isInPosition()) {
            this.setInPosition(false);
            this.getEventQueue().pushEvent(new SignalEvent("TEST", Sides.SHORT));
        }
    }

    @Override
    public void handleTickEvent() {

    }
}
