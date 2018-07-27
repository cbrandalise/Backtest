import data.Bar;
import data.CSVDataHandler;
import data.Sides;
import event.Event;
import event.EventQueue;
import event.SignalEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static Constants.Constants.RESOURCE_PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CSVDataHandlerTest {
    private CSVDataHandler csvDataHandler;
    public void initialize() {
        EventQueue<Event> eventQueue = new EventQueue<>(new SignalEvent("aapl", Sides.LONG));
        csvDataHandler = new CSVDataHandler(RESOURCE_PATH+"SP500_historical.csv", eventQueue);
        csvDataHandler.loadCSVFile();
    }

//    @Test
//    @DisplayName("Should return the latest bar")
//    public void testLatestBar() {
//        initialize();
//        Bar bar = csvDataHandler.popNextBar();
//        assertTrue(bar instanceof Bar);
//    }

    @Test
    @DisplayName("Should return the latest n bars")
    public void testLatestBars() {
        initialize();
        List<Bar> bars = csvDataHandler.getLatestBars(5);
        assertEquals(bars.size(), 5);
    }

    @Test
    @DisplayName("Should update by inserting a bar at the end of the list")
    public void testUpdateBar() {
        initialize();
        Bar bar = new Bar(
                new Date(),
                123.45f,
                127.65f,
                111.45f,
                115.67f,
                1123456
        );

        csvDataHandler.updateBar(bar);
        Bar latestBar = csvDataHandler.getLatestBar();
        assertTrue(latestBar.equals(bar));
    }
}
