package controller;
import models.Veiculo;
import java.util.ArrayList;
import java.util.List;

public class VeiculoController {

    private BuscadorController veiculoBuscador;
    private List<Veiculo> veiculos;



    public VeiculoController() {
        this.veiculoBuscador = new BuscadorController();
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
