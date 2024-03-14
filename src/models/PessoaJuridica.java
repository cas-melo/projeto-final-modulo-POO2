package models;

import util.GeradorCNPJ;

public class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String nome, Veiculo veiculoAlugado) {
        super(nome, veiculoAlugado);
        this.cnpj = GeradorCNPJ.gerarCNPJ();
    }

    public String getDocumento() {
        return cnpj;
    }

    public void setDocumento(String cnpj) {
        this.cnpj = cnpj;
    }
}
