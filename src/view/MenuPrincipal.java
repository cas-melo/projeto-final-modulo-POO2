package view;
import controller.*;
import models.*;
import org.w3c.dom.ls.LSOutput;
import util.TipoVeiculo;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private Scanner scanner;
    private VeiculoController veiculoController;
    private AluguelController aluguelController;
    private CadastroVeiculoView cadastroVeiculoView;
    private AluguelView aluguelView;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        this.veiculoController = new VeiculoController();
        this.aluguelController = new AluguelController();
        this.cadastroVeiculoView = new CadastroVeiculoView(veiculoController);
        this.aluguelView = new AluguelView(veiculoController, aluguelController);
    }

    int escolha;

    public void exibirMenu() {
        while (true) {
            System.out.println("### Locadora de veículos ###");
            System.out.println("\nMenu:");
            System.out.println("1. Veículos");
            System.out.println("2. Clientes");
            System.out.println("3. Aluguéis");
            System.out.println("4. Sair");

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
        System.out.println("### MENU - VEÍCULOS ###");
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
        System.out.println("### MENU - CLIENTES ###");
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
        System.out.println("### MENU - ALUGUÉIS ###");
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
            case 2:
                aluguelView.exibirMenuAluguel();
                break;
            case 3:
                // devolverVeiculo
                break;
            case 4:
                // exibirDevolucoes();
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
            System.out.println("Modelo: " + veiculo.getMarca() + veiculo.getNome() +
                    " | Placa: " + veiculo.getPlaca() + " | Tipo: " + veiculo.getTipo());

            if (veiculo.isDisponivel()){
                System.out.println("Disponível");
            } else {
                System.out.println("Alugado  |  " + "Cliente: " + veiculo.getCliente().getNome() +
                        " | Documento:  " + (veiculo.getCliente()).getDocumento());
            }
        }
    }

    //public void exibirClientes(){}

    public void exibirAlugueisAtivos(){
        System.out.println("\n### LISTA ALUGUÉIS ATIVOS ###");
        for (Aluguel aluguel : aluguelController.listarAlugueis()) {
            System.out.println("Modelo: " + aluguel.getVeiculo().getMarca() + aluguel.getVeiculo().getNome() +
                    " | Placa: " + aluguel.getVeiculo().getPlaca() + " | Tipo: " + aluguel.getVeiculo().getTipo());
            System.out.println("Cliente: " + aluguel.getCliente().getNome() +
                    " | Documento: " + aluguel.getCliente().getDocumento());
            System.out.println("Local: " + aluguel.getCidade() + " | Data de início: " + aluguel.getDataInicio());
        }
    }

    public void exibirDevolucoes(){}

}
