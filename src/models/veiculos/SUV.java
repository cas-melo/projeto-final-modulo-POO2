package models.veiculos;

import util.TipoVeiculo;

public class SUV extends Veiculo {

    private static final double VALOR_DIARIA = 200.00;


    public SUV(String placa, String nome) {
        super(placa, nome, TipoVeiculo.SUV);
    }


    @Override
    public double getValorDiaria() {
        return VALOR_DIARIA;
    }


    @Override
    public void alugar() {
        // lógica para alugar
    }


    @Override
    public void devolver() {
        //lógica para devolver
    }

}