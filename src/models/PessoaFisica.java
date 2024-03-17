package models;

import util.GeradorCPF;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome) {
        super(nome);
        this.cpf = GeradorCPF.gerarCPF();
    }

    public String getDocumento() {
        return this.cpf;
    }

    public void setDocumento(String cpf) {
        this.cpf = cpf;
    }

    public String getTipoDocumento(){
        return "CPF";
    }

}