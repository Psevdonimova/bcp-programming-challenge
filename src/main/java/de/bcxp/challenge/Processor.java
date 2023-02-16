package de.bcxp.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static de.bcxp.challenge.Constants.UNDEFINED;

public interface Processor<T extends Info> {
    Logger LOG = Logger.getLogger(Processor.class.getName());

    default String process(String fileName) {
        List<String[]> lines = parseCsv(fileName);

        if (lines == null) {
            return UNDEFINED;
        }

        if (lines.size() < 2) {
            LOG.warning("File is empty!");
            return UNDEFINED;
        }

        ArrayList<T> infoList = mapLines(lines);

        if (infoList == null) {
            return UNDEFINED;
        }

        return calculate(infoList);
    }

    List<String[]> parseCsv(String fileName);

    ArrayList<T> mapLines(List<String[]> lines);

    String calculate(ArrayList<T> infoList);
}
