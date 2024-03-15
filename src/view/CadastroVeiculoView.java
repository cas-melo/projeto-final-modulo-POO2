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

        System.out.print("Marca do veículo: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo do veículo: ");
        String modelo = scanner.nextLine();

        TipoVeiculo tipo = solicitarTipoVeiculo();

        Cliente cliente = null;

        veiculoController.adicionarVeiculo(marca, modelo, tipo, cliente);
    }

    private TipoVeiculo solicitarTipoVeiculo(){
        TipoVeiculo tipo = null;
        boolean tipoValido = false;

        while (!tipoValido) {
            try {
                System.out.print("Tipo do veículo (PEQUENO, MEDIO ou SUV): ");
                String tipoStr = scanner.next().toUpperCase();
                tipo = TipoVeiculo.valueOf(tipoStr);
                tipoValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de veículo inválido. Por favor, insira PEQUENO, MEDIO ou SUV.");
                scanner.nextLine();
            }
        }

        return tipo;
    }
}
