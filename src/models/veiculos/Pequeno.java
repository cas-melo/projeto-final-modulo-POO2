package models.veiculos;

import util.TipoVeiculo;

public class Pequeno extends Veiculo {

    private static final double VALOR_DIARIA = 100.00;


    public Pequeno(String placa, String modelo) {

        super(placa, modelo, TipoVeiculo.PEQUENO);

    }


    @Override

    public double getValorDiaria() {

        return VALOR_DIARIA;

    }


    @Override

    public void alugar() {

        // Implemente a lógica para alugar um veículo pequeno

    }


    @Override

    public void devolver() {

        // Implemente a lógica para devolver um veículo pequeno

    }

}


