package models;

import java.time.LocalDateTime;

public class Aluguel {

    private Veiculo veiculo;
    private Cliente cliente;
    private String cidade;

    private LocalDateTime dataInicio;


    public Aluguel(Veiculo veiculo, Cliente cliente, String cidade, LocalDateTime dataInicio) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.cidade = cidade;
        this.dataInicio = dataInicio;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }
}
