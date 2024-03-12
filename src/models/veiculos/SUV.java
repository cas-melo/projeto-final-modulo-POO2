package models.veiculos;

import util.TipoVeiculo;

public class SUV extends Veiculo {

    private static final double VALOR_DIARIA = 200.00;


    public SUV(String placa, String modelo) {

        super(placa, modelo, TipoVeiculo.SUV);

    }


    @Override

    public double getValorDiaria() {

        return VALOR_DIARIA;

    }


    @Override

    public void alugar() {

        // Implemente a lógica para alugar um veículo SUV

    }


    @Override

    public void devolver() {

        // Implemente a lógica para devolver um veículo SUV

    }

}