package models;

public class DescontoHelper {

    public static Desconto obterDesconto(Cliente cliente) {
        if (cliente instanceof PessoaFisica) {
            return new DescontoPessoaFisica();
        }
        else if (cliente instanceof PessoaJuridica) {
            return new DescontoPessoaJuridica();
        }
        return null;
    }
}
