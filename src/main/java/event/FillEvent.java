package event;

import java.util.Date;

public class FillEvent extends Event {
    private float price;
    private String symbol;
    private float commission;
    private Date fillTimestamp;
    private String exchange;
    public FillEvent(float price, String symbol, float commission, Date timestamp, String exchange) {
        super(EventTypes.FILL);
        this.price = price;
        this.symbol = symbol;
        this.commission = commission;
        this.fillTimestamp = timestamp;
        this.exchange = exchange;
    }

    public float getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }

    public float getCommission() {
        return commission;
    }

    public Date getFillTimestamp() {
        return fillTimestamp;
    }
}
