package models.veiculos;

import util.TipoVeiculo;

public class Medio extends Veiculo {

    private static final double VALOR_DIARIA = 150.00;


    public Medio(String placa, String modelo) {

        super(placa, modelo, TipoVeiculo.MEDIO);

    }


    @Override

    public double getValorDiaria() {

        return VALOR_DIARIA;

    }


    @Override

    public void alugar() {

        // Implemente a lógica para alugar um veículo médio

    }


    @Override

    public void devolver() {

        // Implemente a lógica para devolver um veículo médio

    }

}

