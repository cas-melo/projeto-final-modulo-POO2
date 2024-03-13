package models;

import util.TipoVeiculo;

public abstract class Veiculo {
    private String placa;
    private String nome;
    private TipoVeiculo tipo;
    private boolean disponivel;

    public Veiculo(String placa, String modelo, TipoVeiculo tipo) {
        this.placa = placa;
        this.nome = modelo;
        this.tipo = tipo;
        this.disponivel = true;
    }

    public String getPlaca() {
        return placa;
    }

    public String getNome() {
        return nome;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }


}
