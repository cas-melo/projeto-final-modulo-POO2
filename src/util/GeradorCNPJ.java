package util;

import java.util.Random;

public class GeradorCNPJ {

    public static String gerarCNPJ() {
        Random random = new Random();

        int[] cnpj = new int[14];

        for (int i = 0; i < 8; i++) {
            cnpj[i] = random.nextInt(10);
        }

        cnpj[8] = 0;
        cnpj[9] = 0;
        cnpj[10] = 0;

        int soma = 0;
        for (int i = 0; i < 4; i++) {
            soma += (5 - i) * cnpj[i];
        }
        for (int i = 0; i < 8; i++) {
            soma += (9 - i) * cnpj[i + 4];
        }

        int digito1 = soma % 11 < 2 ? 0 : 11 - (soma % 11);
        cnpj[12] = digito1;

        soma = 0;
        for (int i = 0; i < 5; i++) {
            soma += (6 - i) * cnpj[i];
        }
        for (int i = 0; i < 8; i++) {
            soma += (9 - i) * cnpj[i + 5];
        }
        int digito2 = soma % 11 < 2 ? 0 : 11 - (soma % 11);
        cnpj[13] = digito2;

        StringBuilder cnpjString = new StringBuilder();
        for (int i = 0; i < 14; i++) {
            cnpjString.append(cnpj[i]);
            if (i == 1 || i == 4) {
                cnpjString.append(".");
            } else if (i == 7) {
                cnpjString.append("/");
            } else if (i == 11) {
                cnpjString.append("-");
            }
        }

        return cnpjString.toString();
    }
}