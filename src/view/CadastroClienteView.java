package view;

import controller.ClienteController;
import util.TipoCliente;

import java.util.Scanner;

public class CadastroClienteView {
    private Scanner scanner;
    private ClienteController clienteController;

    public CadastroClienteView(ClienteController clienteController) {
        this.scanner = new Scanner(System.in);
        this.clienteController = clienteController;
    }

    public void exibirCriarCliente() {
        System.out.println("\n### Cadastro de Cliente ###");

        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();

        TipoCliente tipo = clienteController.solicitarTipoCliente();

        clienteController.cadastrarCliente(nome, tipo);
    }
}
