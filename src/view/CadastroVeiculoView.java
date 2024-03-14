package view;

import controller.VeiculoController;
import models.Cliente;
import util.TipoVeiculo;
import models.Veiculo;
import java.util.Scanner;

public class CadastroVeiculoView {
    private Scanner scanner;
    private VeiculoController veiculoController;

    public CadastroVeiculoView(VeiculoController veiculoController) {
        this.scanner = new Scanner(System.in);
        this.veiculoController = veiculoController;
    }

    public void exibirFormularioCadastro() {
        System.out.println("\n### Cadastro de Veículo ###");
        System.out.println("Placa cadastrada automaticamente");
        System.out.print("Marca do veículo: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo do veículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Tipo do veículo (PEQUENO, MEDIO ou SUV): ");
        String tipoStr = scanner.next().toUpperCase();
        TipoVeiculo tipo = TipoVeiculo.valueOf(tipoStr);
        Cliente cliente = null;

        Veiculo novoVeiculo = new Veiculo(marca, modelo, tipo, cliente);
        veiculoController.adicionarVeiculo(novoVeiculo);
    }
}
