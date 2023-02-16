package de.bcxp.challenge;

import java.util.List;
import java.util.logging.Logger;

import static de.bcxp.challenge.Constants.UNDEFINED;

public interface Processor<T extends InfoList> {
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

        T infoList = mapLines(lines);

        if (infoList == null) {
            return UNDEFINED;
        }

        return calculate(infoList);
    }

    default List<String[]> parseCsv(String fileName) {
        return null;
    }

    default T mapLines(List<String[]> lines) {
        return null;
    }

    default String calculate(T infoList) {
        return null;
    }
}
