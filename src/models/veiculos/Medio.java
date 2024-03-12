package models.veiculos;

import util.TipoVeiculo;

public class Medio extends Veiculo {

    private static final double VALOR_DIARIA = 150.00;


    public Medio(String placa, String nome) {
        super(placa, nome, TipoVeiculo.MEDIO);
    }

    @Override
    public double getValorDiaria() {
        return VALOR_DIARIA;
    }

    @Override
    public void alugar() {
        //lógica para alugar
    }

    @Override
    public void devolver() {
        //lógica para o devolver
    }

}

