package de.bcxp.challenge;

import de.bcxp.challenge.country.CountryDensityProcessor;
import de.bcxp.challenge.temperature.DayTemperatureProcessor;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        String dayWithSmallestTempSpread = new DayTemperatureProcessor().process("src/main/resources/de/bcxp/challenge/weather.csv");
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = new CountryDensityProcessor().process("src/main/resources/de/bcxp/challenge/countries.csv");
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
