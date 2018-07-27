package data;

import data.Bar;

import java.util.List;

public interface DataHandler {
    Bar getLatestBar();
    List<Bar> getLatestBars(int n);
    Float getLatestBarValueOfType();
    void updateBar(Bar bar);
    void latestEvent();
    boolean hasBars();
}
