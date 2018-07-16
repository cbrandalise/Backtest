package algorithm;

import data.Bar;

public class SMAAlgo implements Algorithm {
    @Override
    public void initialize() {
        System.out.println("Initialized called");
    }

    @Override
    public void handleBarEvent(Bar bar) {
        System.out.println(bar.toString());
    }

    @Override
    public void handleTickEvent() {

    }
}
