package models;

public class DescontoPessoaJuridica implements Desconto{

    @Override
    public double calcularDesconto(double valorTotal, long duracaoAluguel) {

        if (duracaoAluguel > 3) {
            return 0.1;
        }
        else {
            return 0.0;
        }
    }
}
