package de.bcxp.challenge.temperature;

import java.util.ArrayList;
import java.util.Comparator;

public class DayTemperatureCalculator {

    public static String calculateDayWithSmallestTempSpread(ArrayList<DayTemperatureInfo> dayTemperatureInfoList) {
        dayTemperatureInfoList.sort(Comparator.comparing(dayTemperatureInfo -> dayTemperatureInfo.getMaxTemperature() - dayTemperatureInfo.getMinTemperature()));

        return dayTemperatureInfoList.get(0).getDayNumber();
    }
}
