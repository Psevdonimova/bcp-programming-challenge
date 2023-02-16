package de.bcxp.challenge.country;

import de.bcxp.challenge.Processor;
import de.bcxp.challenge.parser.CsvFileParser;

import java.util.ArrayList;
import java.util.List;

public class CountryDensityProcessor implements Processor<CountryInfo> {

    @Override
    public List<String[]> parseCsv(String fileName) {
        return CsvFileParser.parseCsvFile(fileName, ';');
    }

    @Override
    public ArrayList<CountryInfo> mapLines(List<String[]> lines) {
        return new CountryDensityMapper().mapLines(lines);
    }

    @Override
    public String calculate(ArrayList<CountryInfo> countryInfoList) {
        return CountryDensityCalculator.calculateCountryWithHighestDensity(countryInfoList);
    }
}
