package view;
import controller.*;
import models.*;
import util.TipoCliente;

import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

public class AluguelView {
    private Scanner scanner;
    private VeiculoController veiculoController;
    private AluguelController aluguelController;
    private ClienteController clienteController;
    private CadastroClienteView cadastroClienteView;


    public AluguelView(VeiculoController veiculoController, AluguelController aluguelController, ClienteController clienteController, CadastroClienteView cadastroClienteView) {
        this.scanner = new Scanner(System.in);
        this.veiculoController = veiculoController;
        this.aluguelController = aluguelController;
        this.clienteController = clienteController;
        this.cadastroClienteView = cadastroClienteView;
    }

    public void exibirMenuAluguel() {
        System.out.println("\n### MENU DE ALUGUEL ###");


        try {
            veiculoController.listarVeiculos();

            System.out.print("Veículo desejado (placa): ");
            String placaDesejada = scanner.nextLine();
            Veiculo veiculoDesejado = veiculoController.buscarVeiculoPorPlaca(placaDesejada);

            if (veiculoDesejado == null) {
               throw new IllegalArgumentException("Veículo não encontrado.");
            }

            Cliente cliente;
            cliente = solicitarCliente();

            if (cliente == null) {
                throw new IllegalArgumentException("Cliente não encontrado.");
            }

            System.out.print("Cidade atual: ");
            String cidade = scanner.nextLine();

            aluguelController.realizarAluguel(veiculoDesejado, cliente, cidade);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private Cliente solicitarCliente() {

        System.out.print("Cliente já cadastrado? (S/N): ");
        String resposta = scanner.next().toUpperCase();
        scanner.nextLine();

        if (resposta.equals("S")) {
            System.out.print("Informe o documento do cliente: ");
            String documento = scanner.nextLine();
            return clienteController.buscarClientePorDocumento(documento);
        } else {
            cadastroClienteView.exibirCriarCliente();
            return clienteController.getUltimoClienteCadastrado();
        }
    }
}
