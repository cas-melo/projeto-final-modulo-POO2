package controller;
import models.Cliente;
import models.Veiculo;
import util.TipoVeiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoController {

    private BuscadorController veiculoBuscador;
    private List<Veiculo> veiculos;

    public VeiculoController() {
        this.veiculoBuscador = new BuscadorController();
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(String marca, String modelo, TipoVeiculo tipo, Cliente cliente) {
        Veiculo novoVeiculo = new Veiculo(marca, modelo, tipo, cliente);

        if (placaJaExistente(novoVeiculo.getPlaca())) {
            System.out.println("Erro: Placa já cadastrada.");
            return;
        }

        System.out.println("Placa cadastrada automaticamente");
        this.veiculos.add(novoVeiculo);
        System.out.println("Veículo cadastrado com sucesso!\n");
    }

    private boolean placaJaExistente(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return true;
            }
        }
        return false;
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public List<Veiculo> listarVeiculos() {
        return this.veiculos;
    }

    public List<Veiculo> buscarVeiculosPorNome(String nome) {
        return veiculoBuscador.buscarPorNome(veiculos, nome);
    }
}
