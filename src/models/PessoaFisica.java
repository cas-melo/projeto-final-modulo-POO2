package models;

import util.GeradorCPF;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, String telefone) {
        super(nome, telefone);
        this.cpf = GeradorCPF.gerarCPF();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Regras de desconto
}
