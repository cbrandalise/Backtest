import algorithm.Algorithm;
import data.DataHandler;
import event.*;
import execution.Execution;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Order;

public class Backtest {
    private boolean runTest;
    private EventQueue eventQueue;
    private DataHandler dataHandler;
    private Algorithm algorithm;
    private Execution execution;
    private final Logger logger;

    public Backtest(EventQueue eventQueue, DataHandler dataHandler, Algorithm algorithm, Execution execution) {
        this.eventQueue = eventQueue;
        this.dataHandler = dataHandler;
        this.algorithm = algorithm;
        this.execution = execution;
        this.logger = LogManager.getLogger(Backtest.class);
    }

    public void initialize() {
        this.run();
    }

    public void run() {
        runTest = true;
        logger.debug("Backtest started.");
        algorithm.initialize();
        while(runTest) {
            if(!this.eventQueue.hasEvent()) {
                dataHandler.latestEvent();
            }

            if(!dataHandler.hasBars()) {
                this.stopTest();
                this.testCompleted();
            }

            Event event = this.eventQueue.popEvent();
            EventTypes type = event.getType();
            switch (type) {
                case BAR:
                    BarEvent barEvent = (BarEvent) event;
                    algorithm.handleBarEvent(barEvent.getBar());
                    break;
                case FILL:
                    FillEvent fillEvent = (FillEvent) event;
                    break;
                case ORDER:
                    OrderEvent orderEvent = (OrderEvent) event;
                    execution.execute(orderEvent);
                    break;
                case SIGNAL:
                    SignalEvent signalEvent = (SignalEvent) event;
                    System.out.println("SIGNAL EVENT FIRED ->" + signalEvent.getSide());
                    this.eventQueue.pushEvent(new OrderEvent(signalEvent.getSymbol(), ));
                    break;
            }
        }
    }

    private void testCompleted() {
        System.out.println("Test Completed");
    }

    public boolean stopTest() {
        System.out.println("Stop test called");
        runTest = false;
        return runTest;
    }

    public boolean isRunTest() {
        return runTest;
    }
}
