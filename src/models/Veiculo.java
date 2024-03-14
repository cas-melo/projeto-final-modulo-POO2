package models;

import util.GeradorPlaca;
import util.TipoVeiculo;

public class Veiculo {
    private String placa;
    private String marca;
    private String nome;
    private TipoVeiculo tipo;
    private boolean disponivel;

    public Veiculo(String marca, String modelo, TipoVeiculo tipo) {
        this.placa = GeradorPlaca.gerarPlaca();
        this.marca = marca;
        this.nome = modelo;
        this.tipo = tipo;
        this.disponivel = true;
    }

    public String getPlaca() {
        return placa;
    }
    public String getMarca() {
        return marca;
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
