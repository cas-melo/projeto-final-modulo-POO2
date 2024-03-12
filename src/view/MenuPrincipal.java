package view;

import controller.VeiculoController;

import java.util.Scanner;

public class MenuPrincipal {

    private Scanner scanner;
    private VeiculoController veiculoController;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        this.veiculoController = new VeiculoController();
        // Inicialize outros controladores aqui
    }

    int escolha;

    public void exibirMenu() {
        while (true) {
            System.out.println("### Locadora de veículos ###");
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar veículo");
            System.out.println("2. Alterar veículo cadastrado");
            System.out.println("3. Buscar veículo por nome");
            System.out.println("4. Cadastrar cliente");
            System.out.println("5. Alterar cliente");
            System.out.println("6. Alugar veículo");
            System.out.println("7. Devolver veículo");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    // cadastrarVeiculo
                    break;
                case 2:
                    // alterarVeiculo
                    break;
                case 3:
                    // buscarVeiculoPorNome
                    break;
                case 4:
                    // Cadastrar cliente
                    break;
                case 5:
                    // Alterar cliente
                    break;
                case 6:
                    // alugarveiculo
                    break;
                case 7:
                    // devolver veiculo
                    break;
                case 8:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
