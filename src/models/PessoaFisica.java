package models;

import util.GeradorCPF;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, Veiculo veiculoAlugado) {
        super(nome, veiculoAlugado);
        this.cpf = GeradorCPF.gerarCPF();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}