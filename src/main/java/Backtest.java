import data.DataHandler;
import event.Event;
import event.EventQueue;
import event.EventTypes;

public class Backtest {
    private boolean runTest;
    private EventQueue eventQueue;
    private DataHandler dataHandler;

    public Backtest(EventQueue eventQueue, DataHandler dataHandler) {
        this.eventQueue = eventQueue;
        this.dataHandler = dataHandler;
    }

    public void initialize() {
        this.run();
    }

    public void run() {
        runTest = true;
        System.out.println("Event Loop initiated");
        while(runTest) {
            Event event = this.eventQueue.popEvent();
            if(!this.eventQueue.hasEvent()) {
                dataHandler.getLatestBar();
            }
            EventTypes type = event.getType();

            switch (type) {
                case BAR:
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
