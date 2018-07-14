import data.Bar;
import data.CSVDataHandler;
import data.Sides;
import event.Event;
import event.EventQueue;
import event.SignalEvent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static Constants.Constants.RESOURCE_PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CSVDataHandlerTest {
    public static CSVDataHandler csvDataHandler;
    @BeforeAll
    public static void initialize() {
        EventQueue<Event> eventQueue = new EventQueue<Event>(new SignalEvent("aapl", Sides.LONG));
        csvDataHandler = new CSVDataHandler(RESOURCE_PATH+"SP500_historical.csv", eventQueue);
        csvDataHandler.loadCSVFile();
    }

    @Test
    void shouldReturnTheLatestBar() {
        Bar bar = csvDataHandler.getLatestBar();
        assertTrue(bar instanceof Bar);
    }

    @Test
    void shouldReturnASetNumberOfBars() {
        List<Bar> bars = csvDataHandler.getLatestBars(5);
        assertEquals(bars.size(), 5);
    }

    @Test
    void shouldUpdateABar() {
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
