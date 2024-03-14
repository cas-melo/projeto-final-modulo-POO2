package view;

import controller.AluguelController;
import controller.VeiculoController;
import models.*;

import java.util.Scanner;

public class AluguelView {
    private Scanner scanner;
    private VeiculoController veiculoController;
    private AluguelController aluguelController;

    public AluguelView(VeiculoController veiculoController, AluguelController aluguelController) {
        this.scanner = new Scanner(System.in);
        this.veiculoController = veiculoController;
        this.aluguelController = aluguelController;
    }

    public void exibirMenuAluguel() {
        System.out.println("\n### MENU DE ALUGUEL ###");

        try {

            System.out.print("Veículo desejado: ");
            String nomeVeiculo = scanner.nextLine();
            Veiculo veiculoDesejado = (Veiculo) veiculoController.buscarVeiculosPorNome(nomeVeiculo); //casting pq tem que ajeitar no buscador
            if (veiculoDesejado == null) {
               throw new IllegalArgumentException("Veículo não encontrado.");
            }

            System.out.print("Cliente já cadastrado? (S/N): ");
            String respostaClienteCadastrado = scanner.next().toUpperCase();
            scanner.nextLine();

            Cliente cliente;
            if (respostaClienteCadastrado.equals("S")){
                System.out.print("Informe o documento do cliente: ");
                String documento = scanner.nextLine();
//                cliente = buscarClientePorDocumento(documento); //RENAN

//                if (cliente == null) {
//                    throw new IllegalArgumentException("Cliente não encontrado.");

                }
//            } else {
//                cliente = cadastrarCliente()  //RENATA
//            }

            scanner.nextLine();


            System.out.print("Cidade atual: ");
            String cidade = scanner.nextLine();

//            aluguelController.realizarAluguel(veiculoDesejado, cliente, cidade);
            System.out.println("Aluguel realizado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
