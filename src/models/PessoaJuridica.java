package models;

import util.GeradorCNPJ;

public class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String nome) {
        super(nome);
        this.cnpj = GeradorCNPJ.gerarCNPJ();
    }

    public String getDocumento() {
        return this.cnpj;
    }

    public void setDocumento(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipoDocumento(){
        return "CNPJ";
    }
}
