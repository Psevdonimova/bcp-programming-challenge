package de.bcxp.challenge.temperature;

import de.bcxp.challenge.Processor;
import de.bcxp.challenge.parser.CsvFileParser;

import java.util.List;

public class DayTemperatureProcessor implements Processor<DayTemperatureInfoList> {

    @Override
    public List<String[]> parseCsv(String fileName) {
        return CsvFileParser.parseCsvFile(fileName, ',');
    }

    @Override
    public DayTemperatureInfoList mapLines(List<String[]> lines) {
        return DayTemperatureMapper.mapDayTemperature(lines);
    }

    @Override
    public String calculate(DayTemperatureInfoList dayTemperatureInfoList) {
        return DayTemperatureCalculator.calculateDayWithSmallestTempSpread(dayTemperatureInfoList);
    }
}
