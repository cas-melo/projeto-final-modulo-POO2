package models;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;



public class DiariaHelper {


    public static int converterMinutosEmDiarias(long minutos) {

        int totalDias = 0;

        long totalHoras = minutos / 60;
        long minutosExcedentes = minutos % 60;

        if(totalHoras <= 24) {
            totalDias = 1;
        }

        while (totalHoras >= 24) {
            totalHoras -= 24;
            totalDias++;
        }

        if (minutosExcedentes > 0) {
            totalDias++;
        }

        return totalDias;
    }
}
