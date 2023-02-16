package de.bcxp.challenge.country;

import java.util.ArrayList;
import java.util.Comparator;

public class CountryDensityCalculator {

    public static String calculateCountryWithHighestDensity(ArrayList<CountryInfo> countryInfoList) {
        countryInfoList.sort(Comparator.comparing(countryInfo -> countryInfo.getPopulation()/countryInfo.getArea()));

        return countryInfoList.get(countryInfoList.size() - 1).getCountry();
    }
}
