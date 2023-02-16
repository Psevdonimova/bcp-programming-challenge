package de.bcxp.challenge.country;

import de.bcxp.challenge.Processor;
import de.bcxp.challenge.parser.CsvFileParser;

import java.util.List;

public class CountryDensityProcessor implements Processor<CountryInfoList> {

    @Override
    public List<String[]> parseCsv(String fileName) {
        return CsvFileParser.parseCsvFile(fileName, ';');
    }

    @Override
    public CountryInfoList mapLines(List<String[]> lines) {
        return CountryDensityMapper.mapCountryDensity(lines);
    }

    @Override
    public String calculate(CountryInfoList countryInfoList) {
        return CountryDensityCalculator.calculateCountryWithHighestDensity(countryInfoList);
    }
}
