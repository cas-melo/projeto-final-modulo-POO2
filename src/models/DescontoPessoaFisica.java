package models;

public class DescontoPessoaFisica implements Desconto{

    @Override
    public double calcularDesconto(double valorTotal, long duracaoAluguel) {

        if (duracaoAluguel > 5) {
            return 0.05;
        }
        else {
            return 0.0;
        }
    }
}
