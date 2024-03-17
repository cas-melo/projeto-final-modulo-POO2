package view;

import controller.VeiculoController;
import exceptions.VeiculoNaoEncontradoException;
import models.Veiculo;
import util.GeradorPlaca;
import util.TipoVeiculo;

import java.util.List;
import java.util.Scanner;

public class BuscarView {

    private Scanner scanner;

    private VeiculoController veiculoController;

    public BuscarView(VeiculoController veiculoController) {
        this.scanner = new Scanner(System.in);
        this.veiculoController = veiculoController;
    }

    public List<Veiculo> exibirMenuBusca() {
        System.out.println("\n### Buscar Veículo ###");

        System.out.println("\nInforme o nome do veículo: ");
        String nome = scanner.nextLine();

        List<Veiculo> resultadoBusca = veiculoController.buscarVeiculosPorNome(nome);
        return resultadoBusca;
    }

}
