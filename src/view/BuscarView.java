package view;

import controller.Paginacao;
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

        System.out.print("\nInforme o nome do veículo: ");
        String nome = scanner.nextLine();

        List<Veiculo> resultadoBusca = veiculoController.buscarVeiculosPorNome(nome);

        System.out.print("\nInforme a quantidade de veículos que deseja ver por página: ");
        int tamanhoPagina = scanner.nextInt();

        System.out.print("\nInforme o número da página que deseja visualizar: ");
        int numeroPagina = scanner.nextInt();

        List<Veiculo> resultadoPaginado = Paginacao.paginar(resultadoBusca, tamanhoPagina, numeroPagina);

        return resultadoPaginado;
    }

}
