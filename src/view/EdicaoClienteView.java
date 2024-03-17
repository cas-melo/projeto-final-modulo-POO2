package view;

import controller.ClienteController;
import controller.VeiculoController;

import java.util.Scanner;

public class EdicaoClienteView {
    private Scanner scanner;
    private ClienteController clienteController;
    public EdicaoClienteView(ClienteController clienteController) {
        this.scanner = new Scanner(System.in);
        this.clienteController = clienteController;
    }
}
