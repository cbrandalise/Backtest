import data.Bar;
import data.CSVDataHandler;
import data.Sides;
import event.Event;
import event.EventQueue;
import event.SignalEvent;
import org.junit.jupiter.api.Test;
import static Constants.Constants.RESOURCE_PATH;

public class CSVDataHandlerTest {
    @Test
    void shouldCreateCSVDataHandlerInstance() {
        EventQueue<Event> eventQueue = new EventQueue<Event>(new SignalEvent("aapl", Sides.LONG));
        CSVDataHandler csvDataHandler = new CSVDataHandler(RESOURCE_PATH+"SP500_historical.csv", eventQueue);
        csvDataHandler.loadCSVFile();
        Bar bar = csvDataHandler.getLatestBar();
    }
}
