package controller;
import models.veiculos.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoController {

    private List<Veiculo> veiculos;

    public VeiculoController() {
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return this.veiculos;
    }

    public List<Veiculo> buscarVeiculosPorNome(String nome) {
        return new VeiculoBuscador().buscarPorNome(this.veiculos, nome);
    }
}
