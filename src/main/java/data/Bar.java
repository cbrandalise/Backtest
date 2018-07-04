package data;

import java.util.Date;

public class Bar {
    private float open;
    private float close;
    private float high;
    private float low;
    private Date timeStamp;

    public Bar(float open, float close, float high, float low, Date timeStamp) {
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.timeStamp = timeStamp;
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

    public Date getTimeStamp() {
        return timeStamp;
    }
}
