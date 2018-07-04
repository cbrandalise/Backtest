package event;

import event.Event;
import event.EventTypes;
import data.Sides;

public class SignalEvent extends Event {
    private String symbol;
    private Sides side;
    public SignalEvent(String symbol, Sides side) {
        super(EventTypes.SIGNAL);
        this.side = side;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public Sides getSide() {
        return side;
    }
}

