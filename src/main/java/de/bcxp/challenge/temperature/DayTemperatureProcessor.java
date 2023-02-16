package de.bcxp.challenge.temperature;

import de.bcxp.challenge.Processor;
import de.bcxp.challenge.parser.CsvFileParser;

import java.util.ArrayList;
import java.util.List;

public class DayTemperatureProcessor implements Processor<DayTemperatureInfo> {

    @Override
    public List<String[]> parseCsv(String fileName) {
        return CsvFileParser.parseCsvFile(fileName, ',');
    }

    @Override
    public ArrayList<DayTemperatureInfo> mapLines(List<String[]> lines) {
        return new DayTemperatureMapper().mapLines(lines);
    }

    @Override
    public String calculate(ArrayList<DayTemperatureInfo> dayTemperatureInfoList) {
        return DayTemperatureCalculator.calculateDayWithSmallestTempSpread(dayTemperatureInfoList);
    }
}
