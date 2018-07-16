import algorithm.Algorithm;
import data.DataHandler;
import event.BarEvent;
import event.Event;
import event.EventQueue;
import event.EventTypes;

public class Backtest {
    private boolean runTest;
    private EventQueue eventQueue;
    private DataHandler dataHandler;
    private Algorithm algorithm;

    public Backtest(EventQueue eventQueue, DataHandler dataHandler, Algorithm algorithm) {
        this.eventQueue = eventQueue;
        this.dataHandler = dataHandler;
        this.algorithm = algorithm;
    }

    public void initialize() {
        this.run();
    }

    public void run() {
        runTest = true;
        System.out.println("Event Loop initiated");
        algorithm.initialize();
        while(runTest) {
            if(!this.eventQueue.hasEvent()) {
                dataHandler.latestEvent();
            }

            Event event = this.eventQueue.popEvent();
            EventTypes type = event.getType();
            switch (type) {
                case BAR:
                    System.out.println("Bar event");
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

    public boolean stopTest() {
        System.out.println("Stop test called");
        runTest = false;
        return runTest;
    }

    public boolean isRunTest() {
        return runTest;
    }
}
