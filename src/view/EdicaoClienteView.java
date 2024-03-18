package view;

import controller.ClienteController;
import exceptions.*;
import models.Cliente;
import models.Veiculo;
import services.AluguelService;
import util.TipoCliente;

import java.util.List;
import java.util.Scanner;

public class EdicaoClienteView {
    private Scanner scanner;
    private ClienteController clienteController;
    public EdicaoClienteView(ClienteController clienteController) {
        this.scanner = new Scanner(System.in);
        this.clienteController = clienteController;
    }

    public void exibirEdicaoCliente() {
        System.out.println("\n### Edição de Cliente ###");

        clienteController.listarClientes();

        Cliente cliente;
        try {

            System.out.print("\nDigite o documento do cliente que deseja alterar: ");
            String documento = scanner.nextLine();

            cliente = clienteController.buscarClientePorDocumento(documento);

            List<Veiculo> veiculosDoCliente = AluguelService.getVeiculosPorCliente(cliente);

            if (cliente == null) {
                throw new ClienteNaoEncontradoException("Documento " + documento + "não encontrado.");
            }

            if (!veiculosDoCliente.isEmpty())
            {
                System.out.println("Por favor, devolva todos os veículos do cliente antes de efetuar a alteração.");

                return;
            }



            System.out.print("Digite o novo nome do cliente: ");
            String nome = scanner.nextLine();
            if (nome.isEmpty() || nome.isBlank()) {
                throw new IllegalArgumentException("Nome inválido!");
            }

            TipoCliente tipo = clienteController.solicitarTipoCliente();

            clienteController.alterarCliente(documento, nome, tipo);

            System.out.println("Cliente alterado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (ClienteNaoEncontradoException clienteNaoEncontradoException) {
            System.out.println("Cliente não encontrado. Tente novamente!");
        } catch (Exception e) {
            System.out.println("Erro inesperado. Entre em contato com o suporte.");
            e.printStackTrace();

        }
    }
}
