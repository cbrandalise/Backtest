package data;

import data.Bar;

public interface DataHandler {
    public Bar getLatestBar();
    public Bar getLatestBars();
    public Float getLatestBarValueOfType();
    public void updateBar(Bar bar);
}
