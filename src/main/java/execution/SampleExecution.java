package execution;

import data.DataHandler;
import event.*;

import java.util.Date;

public class SampleExecution extends Execution {
    private float commission;
    public SampleExecution(EventQueue<Event> eventQueue, DataHandler dataHandler, float commission) {
        super(eventQueue, dataHandler);
        this.commission = commission;
    }

    @Override
    public void execute(OrderEvent event) {
        //TODO: Connect to broker etc!!!
        float fillPrice = 0;
        switch (event.getOrderType()){
            case MARKET:
                fillPrice = this.getDataHandler()
                                .getLatestBar()
                                .getClose();
                break;
            case LIMIT:
                break;
        }
        this.getEventQueue().pushEvent(
            new FillEvent(
                    fillPrice,
                    event.getSymbol(),
                    event.getQuantity() * commission,
                    new Date(),
                    "NYSE"
            )
        );
    }
}
