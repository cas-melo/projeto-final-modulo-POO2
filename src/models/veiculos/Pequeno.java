package models.veiculos;

import util.TipoVeiculo;

public class Pequeno extends Veiculo {

    private static final double VALOR_DIARIA = 100.00;


    public Pequeno(String placa, String nome) {
        super(placa, nome, TipoVeiculo.PEQUENO);
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
        // lógica para devolver
    }

}


