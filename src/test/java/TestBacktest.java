import Constants.Constants;
import algorithm.SMAAlgo;
import data.CSVDataHandler;
import data.Sides;
import event.Event;
import event.EventQueue;
import event.SignalEvent;
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
        Backtest backtest = new Backtest(eventQueue, dataHandler, smaAlgo);
        backtest.initialize();
//
//        backtest.stopTest();
//        assertEquals(1+1, 2);
    }
}
