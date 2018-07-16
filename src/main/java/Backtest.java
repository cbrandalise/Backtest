import algorithm.Algorithm;
import data.DataHandler;
import event.BarEvent;
import event.Event;
import event.EventQueue;
import event.EventTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Backtest {
    private boolean runTest;
    private EventQueue eventQueue;
    private DataHandler dataHandler;
    private Algorithm algorithm;
    private final Logger logger;

    public Backtest(EventQueue eventQueue, DataHandler dataHandler, Algorithm algorithm) {
        this.eventQueue = eventQueue;
        this.dataHandler = dataHandler;
        this.algorithm = algorithm;
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
                    logger.debug("Bar event");
                    BarEvent barEvent = (BarEvent) event;
                    algorithm.handleBarEvent(barEvent.getBar());
                    break;
                case FILL:
                    break;
                case ORDER:
                    break;
                case MARKET:
                    break;
                case SIGNAL:
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
