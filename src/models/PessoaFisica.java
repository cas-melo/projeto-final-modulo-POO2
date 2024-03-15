package models;

import util.GeradorCPF;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, Veiculo veiculoAlugado, String cpf) {
        super(nome, veiculoAlugado);
        this.cpf = cpf;  //TODO tirar teste
        // this.cpf = GeradorCPF.gerarCPF(); //TODO inserir gerador
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