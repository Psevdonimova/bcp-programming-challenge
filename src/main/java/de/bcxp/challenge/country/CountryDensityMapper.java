package de.bcxp.challenge.country;

import de.bcxp.challenge.mapper.InfoMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static de.bcxp.challenge.Constants.*;

public class CountryDensityMapper implements InfoMapper<CountryInfo> {
    private static final Logger LOG = Logger.getLogger(CountryDensityMapper.class.getName());

    @Override
    public ArrayList<CountryInfo> mapLines(List<String[]> lines) {
        ArrayList<CountryInfo> countryDensities = new ArrayList<>();

        List<String> header = new ArrayList<>(List.of(lines.get(0)));
        int indexCountry = header.indexOf(COUNTRY);
        int indexPopulation = header.indexOf(POPULATION);
        int indexArea = header.indexOf(AREA);

        if (indexCountry == -1 || indexPopulation == -1 || indexArea == -1) {
            LOG.warning("One of the column is missing!");
            return null;
        }

        double population;
        double area;
        for (int i = 1; i < lines.size(); i++) {
            String[] line = lines.get(i);

            try {
                population = Double.parseDouble(replaceSeparators(line[indexPopulation]));
                area = Double.parseDouble(replaceSeparators(line[indexArea]));
            } catch (NumberFormatException ex) {
                LOG.warning(ex + " in line " + i + "!");
                return null;
            }

            if (population - (int) population > 0) {
                LOG.warning("Population is not a whole number in line " + i + "!");
                return null;
            }

            if (Double.compare(population, 0) < 0) {
                LOG.warning("Population is less than zero in line " + i + "!");
                return null;
            }

            if (Double.compare(area, 0) <= 0) {
                LOG.warning("Area is zero or less km2 in line " + i + "!");
                return null;
            }

            countryDensities.add(new CountryInfo(line[indexCountry], population, area));
        }

        return countryDensities;
    }

    private static String replaceSeparators(String stringToParse) {
        return stringToParse.replace(".", "").replace(",", ".");
    }
}
