package event;

import data.Sides;

public class OrderEvent extends Event {
    private String symbol;
    private int quantity;
    private OrderTypes orderType;
    private Sides side;

    public OrderEvent(String symbol, int quantity, OrderTypes orderType, Sides side) {
        super(EventTypes.ORDER);
        this.symbol = symbol;
        this.quantity = quantity;
        this.orderType = orderType;
        this.side = side;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderTypes getOrderType() {
        return orderType;
    }

    public Sides getSide() {
        return side;
    }
}
