package de.bcxp.challenge;

import de.bcxp.challenge.country.CountryDensityProcessor;
import de.bcxp.challenge.temperature.DayTemperatureProcessor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 */
public class AppTest {
    final DayTemperatureProcessor dayTemperatureProcessor = new DayTemperatureProcessor();
    final CountryDensityProcessor countryDensityProcessor = new CountryDensityProcessor();
    final String PATH = "src/test/resources/";

    @Test
    public void resultUndefinedWeatherTest() {
        List<String> files = List.of("no_file.csv", "weather_empty_file.csv", "weather_no_column.csv", "weather_empty_value.csv",
                "weather_wrong_format_value.csv", "weather_invalid_value.csv");
        files.forEach(file ->
                assertEquals("undefined", dayTemperatureProcessor.process(PATH + file)));
    }

    @Test
    public void resultUndefinedCountriesTest() {
        List<String> files = List.of("countries_negative_value.csv", "countries_not_integer_population.csv", "countries_zero_area.csv");
        files.forEach(file ->
                assertEquals("undefined", countryDensityProcessor.process(PATH + file)));
    }

    @Test
    public void weatherTest() {
        assertEquals("14", dayTemperatureProcessor.process(PATH + "weather.csv"));
    }

    @Test
    public void countriesTest() {
        assertEquals("Malta", countryDensityProcessor.process(PATH + "countries.csv"));
    }
}