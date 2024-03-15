package view;
import controller.*;
import models.*;

import java.util.Scanner;

public class MenuPrincipal {

    private Scanner scanner;
    private VeiculoController veiculoController;
    private AluguelController aluguelController;
    private DevolucaoController devolucaoController;
    private CadastroVeiculoView cadastroVeiculoView;
    private AluguelView aluguelView;
    private DevolucaoView devolucaoView;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        this.veiculoController = new VeiculoController();
        this.aluguelController = new AluguelController();
        this.devolucaoController = new DevolucaoController(aluguelController);
        this.cadastroVeiculoView = new CadastroVeiculoView(veiculoController);
        this.aluguelView = new AluguelView(veiculoController, aluguelController);
        this.devolucaoView = new DevolucaoView(veiculoController, devolucaoController, aluguelController);
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
                cadastroVeiculoView.exibirFormularioCadastro();
                break;
            case 3:
                // alterarVeiculo
                break;
            case 4:
                // buscarVeiculoPorNome
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
                // exibirClientes
            case 2:
                // cadastrarCliente
                break;
            case 3:
                // alterarCliente
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
        System.out.println("\n### VEÍCULOS CADASTRADOS ###");
        for (Veiculo veiculo : veiculoController.listarVeiculos()) {
            System.out.println("\nModelo: " + veiculo.getMarca() + " " + veiculo.getNome() +
                    " | Placa: " + veiculo.getPlaca() + " | Tipo: " + veiculo.getTipo());

            if (veiculo.isDisponivel()){
                System.out.println("Disponível");
            } else {
                Cliente cliente = veiculo.getCliente();
                System.out.println("Alugado | Cliente: " + cliente.getNome() +
                        " | " + cliente.getTipoDocumento() + ": " + cliente.getDocumento());
            }
        }

        System.out.println("\nPressione ENTER para voltar ao menu principal.");
        scanner.nextLine();
        scanner.nextLine();
        exibirMenu();
    }

    //public void exibirClientes(){}

    public void exibirAlugueisAtivos(){
        System.out.println("\n### LISTA ALUGUÉIS ATIVOS ###");

        for (Aluguel aluguel : aluguelController.listarAlugueis()) {
            String dataInicioFormat = devolucaoController.formatarLocalDateTime(aluguel.getDataInicio());

            System.out.println("\nModelo: " + aluguel.getVeiculo().getMarca() + " " + aluguel.getVeiculo().getNome() +
                    " | Placa: " + aluguel.getVeiculo().getPlaca() + " | Tipo: " + aluguel.getVeiculo().getTipo());
            System.out.println("Cliente: " + aluguel.getCliente().getNome() + " | " +
                    aluguel.getCliente().getTipoDocumento() + ": " + aluguel.getCliente().getDocumento());
            System.out.println("Local: " + aluguel.getCidade() + " | Data de início: " + dataInicioFormat);

            System.out.println("\nPressione ENTER para voltar ao menu principal.");
            scanner.nextLine();
            scanner.nextLine();
            exibirMenu();
        }
    }

    public void exibirDevolucoes(){
        System.out.println("\n### LISTA DE ALUGUÉIS FINALIZADOS ###");

        for (Devolucao devolucao : devolucaoController.listarDevolucoes()) {
            String dataInicioFormat = devolucaoController.formatarLocalDateTime(devolucao.getDataInicio());
            String dataFimFormat = devolucaoController.formatarLocalDateTime(devolucao.getDataFim());

            System.out.println("\nModelo: " + devolucao.getVeiculo().getMarca() + " " + devolucao.getVeiculo().getNome() +
                    " | Placa: " + devolucao.getVeiculo().getPlaca() + " | Tipo: " + devolucao.getVeiculo().getTipo());
            System.out.println("Cliente: " + devolucao.getCliente().getNome() + " | " +
                    devolucao.getCliente().getTipoDocumento() + ": " + devolucao.getCliente().getDocumento());
            System.out.println("Local: " + devolucao.getCidade() + " | Data de início: " + dataInicioFormat +
                    " | Data do fim: " + dataFimFormat + " | Valor: " + devolucao.getValorTotal());
        }

        System.out.println("\nPressione ENTER para voltar ao menu principal.");
        scanner.nextLine();
        scanner.nextLine();
        exibirMenu();
    }
}
