package view;
import controller.*;
import models.*;
import services.AluguelService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuPrincipal {

    ImprimirBuscaController impressora = new ImprimirBuscaController();
    private Scanner scanner;
    private final VeiculoController veiculoController;
    private final ClienteController clienteController;
    private final AluguelController aluguelController;
    private final DevolucaoController devolucaoController;
    private final CadastroVeiculoView cadastroVeiculoView;
    private final AluguelView aluguelView;
    private final DevolucaoView devolucaoView;
    private final CadastroClienteView cadastroClienteView;
    private final AluguelService aluguelService;
    private final BuscarView buscarView;
    private final EdicaoVeiculoView edicaoVeiculoView;
    private final EdicaoClienteView edicaoClienteView;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        this.veiculoController = new VeiculoController();
        this.aluguelService = new AluguelService();
        this.clienteController = new ClienteController(aluguelService);
        this.aluguelController = new AluguelController();
        this.devolucaoController = new DevolucaoController(aluguelController, aluguelService);
        this.cadastroVeiculoView = new CadastroVeiculoView(veiculoController);
        this.cadastroClienteView = new CadastroClienteView(clienteController);
        this.aluguelView = new AluguelView(veiculoController, aluguelController, clienteController, cadastroClienteView);
        this.devolucaoView = new DevolucaoView(veiculoController, devolucaoController, aluguelController);
        this.buscarView = new BuscarView(veiculoController);
        this.edicaoVeiculoView = new EdicaoVeiculoView(veiculoController);
        this.edicaoClienteView = new EdicaoClienteView(clienteController);
    }

    int escolha;

    public void exibirMenu() {
        while (true) {
            System.out.println("\n### LOCADORA DE VEÍCULOS ###");
            System.out.println("Menu:");
            System.out.println("1. Veículos");
            System.out.println("2. Clientes");
            System.out.println("3. Aluguéis");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    menuVeiculos();
                    break;
                case 2:
                    menuClientes();
                    break;
                case 3:
                    menuAlugueis();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // SUB-MENUS
    public void menuVeiculos() {
        System.out.println("\n### MENU - VEÍCULOS ###");
        System.out.println("1. Exibir todos os veículos");
        System.out.println("2. Cadastrar veículo");
        System.out.println("3. Alterar veículo cadastrado");
        System.out.println("4. Buscar veículo por nome");
        System.out.println("5. Voltar para o menu principal");
        System.out.print("Escolha uma opção: ");

        escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                exibirVeiculos();
                break;
            case 2:
                cadastroVeiculoView.exibirCriarVeiculo();
                break;
            case 3:
                edicaoVeiculoView.exibirEdicaoVeiculo();
                break;
            case 4:
                List<Veiculo> resultado = buscarView.exibirMenuBusca();
                impressora.imprimirBusca(resultado);
                break;
            case 5:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void menuClientes() {
        System.out.println("\n### MENU - CLIENTES ###");
        System.out.println("1. Exibir clientes");
        System.out.println("2. Cadastrar cliente");
        System.out.println("3. Alterar cliente");
        System.out.println("4. Voltar para o menu principal");
        System.out.print("Escolha uma opção: ");

        escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                exibirClientes();
                break;
            case 2:
                cadastroClienteView.exibirCriarCliente();
                break;
            case 3:
                edicaoClienteView.exibirEdicaoCliente();
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void menuAlugueis() {
        System.out.println("\n### MENU - ALUGUÉIS ###");
        System.out.println("1. Exibir aluguéis ativos");
        System.out.println("2. Alugar veículo");
        System.out.println("3. Devolver veículo");
        System.out.println("4. Exibir aluguéis finalizados");
        System.out.println("5. Voltar para o menu principal");
        System.out.print("Escolha uma opção: ");

        escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                exibirAlugueisAtivos();
                break;
            case 2:
                aluguelView.exibirMenuAluguel();
                break;
            case 3:
                devolucaoView.exibirMenuDevolucao();
                break;
            case 4:
                exibirDevolucoes();
                break;
            case 5:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }



    // MENUS DE EXIBIÇÃO
    public void exibirVeiculos(){

        veiculoController.listarVeiculos();

        System.out.println("\nPressione ENTER para voltar ao menu principal.");
        scanner.nextLine();
        scanner.nextLine();
        exibirMenu();
    }

    public void exibirClientes(){
        clienteController.listarClientes();

        System.out.println("\nPressione ENTER para voltar ao menu principal.");
        scanner.nextLine();
        scanner.nextLine();
        exibirMenu();
    }

    public void exibirAlugueisAtivos(){
        aluguelController.listarAlugueis();

        System.out.println("\nPressione ENTER para voltar ao menu principal.");
        scanner.nextLine();
        scanner.nextLine();
        exibirMenu();
    }

    public void exibirDevolucoes(){
        devolucaoController.listarDevolucoes();

        System.out.println("\nPressione ENTER para voltar ao menu principal.");
        scanner.nextLine();
        scanner.nextLine();
        exibirMenu();
    }
}
