package data;

import event.BarEvent;
import event.Event;
import event.EventQueue;
import util.CSVReader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static Constants.Constants.DATE_FORMAT;

public class CSVDataHandler implements DataHandler {
    private String path;
    private ArrayList<Bar> bars;
    private EventQueue<Event> eventQueue;

    public CSVDataHandler(String path, EventQueue eventQueue) {
        this.path = path;
        bars = new ArrayList<>();
        this.eventQueue = eventQueue;
        this.loadCSVFile();
    }

    public void loadCSVFile() {
        String[][] data = CSVReader.read(this.path, ",");
        loadBars(data);
    }

    public Bar getLatestBar() {
        if(bars.size() == 0) return null;
        return bars.remove(0);
    }

    public List<Bar> getLatestBars(int n) {
        int end = bars.size() - 1;
        int from = end - n;
        return bars.subList(from, end);
    }

    public void latestEvent() {
        Bar bar = this.getLatestBar();
        if(bar != null) {
            System.out.println("Pushing a bar event");
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
        return bars.size() > 0;
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
