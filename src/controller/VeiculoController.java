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

    public void adicionarVeiculo(Veiculo novoVeiculo) {
        if (!placaJaExistente(novoVeiculo.getPlaca())) {
            this.veiculos.add(novoVeiculo);
            System.out.println("Veículo cadastrado com sucesso!\n");
        } else {
            System.out.println("Erro: Placa ja cadastrada.");
        }
    }

    private boolean placaJaExistente(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return true;
            }
        }
        return false;
    }

    public List<Veiculo> listarVeiculos() {
        return this.veiculos;
    }

    public List<Veiculo> buscarVeiculosPorNome(String nome) {
        return veiculoBuscador.buscarPorNome(veiculos, nome);
    }
}
