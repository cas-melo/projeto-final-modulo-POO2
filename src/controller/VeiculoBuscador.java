package controller;

import models.veiculos.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoBuscador {

    public List<Veiculo> buscarPorNome(List<Veiculo> veiculos, String nome) {

        List<Veiculo> resultado = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getNome().contains(nome)) {
                resultado.add(veiculo);
            }
        }
        return resultado;
    }
}
