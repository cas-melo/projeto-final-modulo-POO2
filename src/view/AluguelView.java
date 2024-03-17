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


    public AluguelView(VeiculoController veiculoController, AluguelController aluguelController, ClienteController clienteController) {
        this.scanner = new Scanner(System.in);
        this.veiculoController = veiculoController;
        this.aluguelController = aluguelController;
        this.clienteController = clienteController;
    }

    public void exibirMenuAluguel() {
        System.out.println("\n### MENU DE ALUGUEL ###");

        try {
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
        String respostaClienteCadastrado = scanner.next().toUpperCase();
        scanner.nextLine();

        Cliente cliente = null;
        String documento = "";
        if (respostaClienteCadastrado.equals("S")) {
            System.out.print("Informe o documento do cliente: ");
            documento = scanner.nextLine();

//            cliente = new PessoaFisica("João Silva"); //TODO tirar teste
          cliente = clienteController.buscarClientePorDocumento(documento);

            return cliente;
        } else {
            cliente = clienteView.exibirCriarCliente; //TODO ARRUMAR
            return cliente;
        }
        return null;
    }
}
