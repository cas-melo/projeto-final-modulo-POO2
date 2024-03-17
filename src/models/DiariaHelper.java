package models;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DiariaHelper {

    public static int converterHorasEmDiarias(long horas, LocalDateTime dataInicio, LocalDateTime dataFim) {

        int totalDias = 0;

        if (horas <= 24) {
            return 1;
        }

        while (horas >= 24) {
            horas -= 24;
            totalDias++;

        }
        if (horas > 0) {
            if (ChronoUnit.MINUTES.between(dataInicio, dataFim.plusHours(horas)) % 60 > 0) {
                totalDias++;
            }

        }
        return totalDias;
    }
}
