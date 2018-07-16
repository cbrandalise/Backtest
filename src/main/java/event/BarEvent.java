package event;

import data.Bar;

public class BarEvent extends Event {
    private String symbol;
    private Bar bar;

    public BarEvent(String symbol, Bar bar) {
        super(EventTypes.BAR);
        this.symbol = symbol;
        this.bar = bar;
    }

    public Bar getBar() {
        return bar;
    }
}
