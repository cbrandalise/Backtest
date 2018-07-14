package data;

import java.util.Date;

public class Bar {
    private float open;
    private float close;
    private float high;
    private float low;
    private long volume;
    private Date date;

    public Bar(Date date, float open, float high, float low, float close, long volume) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public float getOpen() {
        return open;
    }

    public float getClose() {
        return close;
    }

    public float getHigh() {
        return high;
    }

    public float getLow() {
        return low;
    }

    public long getVolume() {
        return volume;
    }

    public Date getTimeStamp() {
        return date;
    }
}
