import event.Event;
import event.EventQueue;
import event.EventTypes;

public class Backtest {
    private boolean runTest = false;
    private EventQueue eventQueue;

    public Backtest(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
    }

    public void initialize() {
        runTest = true;

        while(runTest) {
            while(this.eventQueue.hasEvent()) {
                Event event = this.eventQueue.popEvent();
                EventTypes type = event.getType();

                switch (type) {
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
    }

    public boolean stopTest() {
        runTest = false;
        return runTest;
    }
}
