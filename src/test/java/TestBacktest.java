import Constants.Constants;
import algorithm.SMAAlgo;
import data.CSVDataHandler;
import data.Sides;
import event.Event;
import event.EventQueue;
import event.SignalEvent;
import execution.Execution;
import execution.SampleExecution;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestBacktest {
    @BeforeAll
    public static void initialize() {
    }

    @Test
    @DisplayName("should create an backtester instance")
    public void testInstantiateBacktest() {
        EventQueue<Event> eventQueue = new EventQueue<>(new SignalEvent("aapl", Sides.LONG));
        CSVDataHandler dataHandler = new CSVDataHandler(Constants.RESOURCE_PATH+"SP500_historical.csv", eventQueue);
        SMAAlgo smaAlgo = new SMAAlgo(eventQueue);
        Execution sampleExecution = new SampleExecution(eventQueue, dataHandler, 1.34f);
        Backtest backtest = new Backtest(eventQueue, dataHandler, smaAlgo, sampleExecution);
        backtest.initialize();
    }
}
