package de.bcxp.challenge.parser;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class CsvFileParser {
    private static final Logger LOG = Logger.getLogger(CsvFileParser.class.getName());

    public static List<String[]> parseCsvFile(String fileName, char separator) {
        List<String[]> lines;

        try (CSVReader csvReader = new CSVReader(new FileReader(fileName), separator)) {
            lines = csvReader.readAll();
        } catch (IOException ex) {
            LOG.warning(ex.toString());
            return null;
        }

        return lines;
    }
}
