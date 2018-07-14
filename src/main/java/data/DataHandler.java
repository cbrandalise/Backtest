package data;

import data.Bar;

import java.util.List;

public interface DataHandler {
    public Bar getLatestBar();
    public List<Bar> getLatestBars(int n);
    public Float getLatestBarValueOfType();
    public void updateBar(Bar bar);
}
