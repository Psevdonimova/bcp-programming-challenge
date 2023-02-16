package de.bcxp.challenge.temperature;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static de.bcxp.challenge.Constants.*;

public class DayTemperatureMapper {
    private static final Logger LOG = Logger.getLogger(DayTemperatureMapper.class.getName());

    public static DayTemperatureInfoList mapDayTemperature(List<String[]> lines) {
        DayTemperatureInfoList dayTemperatures = new DayTemperatureInfoList();

        List<String> header = new ArrayList<>(List.of(lines.get(0)));
        int indexDay = header.indexOf(DAY);
        int indexTempMax = header.indexOf(MXT);
        int indexTempMin = header.indexOf(MNT);

        if (indexDay == -1 || indexTempMax == -1 || indexTempMin == -1) {
            LOG.warning("Some of the columns are missing!");
            return null;
        }

        int tempMaxInt;
        int tempMinInt;
        for (int i = 1; i < lines.size(); i++) {
            String[] line = lines.get(i);

            try {
                tempMaxInt = Integer.parseInt(line[indexTempMax]);
                tempMinInt = Integer.parseInt(line[indexTempMin]);
            } catch (NumberFormatException ex) {
                LOG.warning(ex + " in line " + i + "!");
                return null;
            }

            if (tempMaxInt - tempMinInt < 0) {
                LOG.warning("Maximal temperature is lower than minimal temperature in line " + i + "!");
                return null;
            }

            dayTemperatures.add(new DayTemperatureInfo(line[indexDay], tempMinInt, tempMaxInt));
        }

        return dayTemperatures;
    }
}
