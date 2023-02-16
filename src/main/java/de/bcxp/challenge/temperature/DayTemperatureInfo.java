package de.bcxp.challenge.temperature;

import de.bcxp.challenge.Info;

public class DayTemperatureInfo implements Info {
    private final String dayNumber;
    private final int minTemperature;
    private final int maxTemperature;

    public DayTemperatureInfo(String dayNumber, int minTemperature, int maxTemperature) {
        this.dayNumber = dayNumber;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public String getDayNumber() {
        return dayNumber;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }
}
