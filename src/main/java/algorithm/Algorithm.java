package algorithm;

import data.Bar;

public interface Algorithm {
    void initialize();
    void handleBarEvent(Bar bar);
    void handleTickEvent();
}
