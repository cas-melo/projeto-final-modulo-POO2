package controller;
import models.veiculos.Veiculo;
import java.util.ArrayList;
import java.util.List;

public class VeiculoController {

    private VeiculoBuscador veiculoBuscador;
    private List<Veiculo> veiculos;



    public VeiculoController() {
        this.veiculoBuscador = new VeiculoBuscador();
        this.veiculos = new ArrayList<>();
    }


    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return this.veiculos;
    }

    public List<Veiculo> buscarVeiculosPorNome(String nome) {
        return veiculoBuscador.buscarPorNome(veiculos, nome);
    }
}
