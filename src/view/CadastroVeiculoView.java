package view;

import controller.VeiculoController;
import util.TipoVeiculo;
import java.util.Scanner;

public class CadastroVeiculoView {
    private Scanner scanner;
    private VeiculoController veiculoController;

    public CadastroVeiculoView(VeiculoController veiculoController) {
        this.scanner = new Scanner(System.in);
        this.veiculoController = veiculoController;
    }

    public void exibirCriarVeiculo() {
        System.out.println("\n### Cadastro de Veículo ###");

        System.out.print("Marca do veículo: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo do veículo: ");
        String modelo = scanner.nextLine();

        TipoVeiculo tipo = veiculoController.solicitarTipoVeiculo();

        veiculoController.adicionarVeiculo(marca, modelo, tipo);
    }


}
