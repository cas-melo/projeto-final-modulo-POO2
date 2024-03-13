package util;

import java.util.Random;

public class GeradorPlaca {

    private static final Random RANDOM = new Random();
    private static final char[] LETRAS  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private static final int NUM_LETRAS = 3;

    private static final int NUM_DIGITOS = 1;

    public static String gerarPlaca() {
        StringBuilder placa = new StringBuilder();

        for (int i = 0; i < NUM_LETRAS; i++) {
            char letra = LETRAS[RANDOM.nextInt(LETRAS.length)];
            placa.append(letra);
        }


        for (int i = 0; i < NUM_DIGITOS; i++) {
            placa.append(RANDOM.nextInt(10));
        }


        char letra = LETRAS[RANDOM.nextInt(LETRAS.length)];
        placa.append(letra);


        for (int i = 0; i < 2; i++) {
            placa.append(RANDOM.nextInt(10));
        }

        return placa.toString();
    }

}
