package controller;
import models.veiculos.Veiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import java.awt.print.Pageable;
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
