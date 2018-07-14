package data;

import event.Event;
import event.EventQueue;
import util.CSVReader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static Constants.Constants.DATE_FORMAT;

public class CSVDataHandler implements DataHandler {
    private String path;
    ArrayList<Bar> bars;
    EventQueue<Event> eventQueue;

    public CSVDataHandler(String path, EventQueue eventQueue) {
        this.path = path;
        bars = new ArrayList<>();
        this.eventQueue = eventQueue;
    }

    public void loadCSVFile() {
        String[][] data = CSVReader.read(this.path, ",");
        loadBars(data);
    }

    public Bar getLatestBar() {
        if(bars.size() == 0) return null;
        return bars.get(bars.size() -1);
    }

    public Bar getLatestBars() {
        return null;
    }

    public Float getLatestBarValueOfType() {
        return null;
    }

    public void updateBar(Bar bar) {
        bars.add(bar);
    }

    private void loadBars(String[][] rawData) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        for (String[] barData : rawData) {
            try {
               Date date = formatter.parse(barData[0]);

                Bar b = new Bar(
                            date,
                            Float.valueOf(barData[1]),
                            Float.valueOf(barData[2]),
                            Float.valueOf(barData[3]),
                            Float.valueOf(barData[4]),
                            Long.valueOf(barData[6])
                        );
                bars.add(b);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
