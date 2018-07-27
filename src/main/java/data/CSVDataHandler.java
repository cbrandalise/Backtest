package data;

import event.BarEvent;
import event.Event;
import event.EventQueue;
import util.CSVReader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static Constants.Constants.DATE_FORMAT;

public class CSVDataHandler implements DataHandler {
    private String path;
    private LinkedList<Bar> bars;
    private EventQueue<Event> eventQueue;
    private Iterator<Bar> barIterator;
    private Bar currentBar;

    public CSVDataHandler(String path, EventQueue eventQueue) {
        this.path = path;
        bars = new LinkedList<>();
        this.eventQueue = eventQueue;
        this.loadCSVFile();
        barIterator = bars.listIterator();
        currentBar = bars.get(0);
    }

    public void loadCSVFile() {
        String[][] data = CSVReader.read(this.path, ",");
        loadBars(data);
    }

    public Bar getLatestBar() {
        if(currentBar != null) {
            System.out.println(String.format("--> The current bar: %s", currentBar.toString()));
            return currentBar;
        }

        return null;
    }

    public List<Bar> getLatestBars(int n) {
        int end = bars.size() - 1;
        int from = end - n;
        return bars.subList(from, end);
    }

    public void latestEvent() {
        if(barIterator.hasNext()) {
            Bar bar = barIterator.next();
            currentBar = bar;
            this.eventQueue.pushEvent(new BarEvent("SPY", bar));
        }
    }

    public Float getLatestBarValueOfType() {
        return null;
    }

    public void updateBar(Bar bar) {
        bars.add(bar);
    }

    public boolean hasBars() {
        return barIterator.hasNext();
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
