package view;
import controller.AluguelController;
import controller.DevolucaoController;
import controller.VeiculoController;
import models.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class DevolucaoView {
    private Scanner scanner;
    private VeiculoController veiculoController;
    private DevolucaoController devolucaoController;
    private AluguelController aluguelController;

    public DevolucaoView(VeiculoController veiculoController, DevolucaoController devolucaoController, AluguelController aluguelController) {
        this.scanner = new Scanner(System.in);
        this.veiculoController = veiculoController;
        this.devolucaoController = devolucaoController;
        this.aluguelController = aluguelController;
    }

    public void exibirMenuDevolucao(){
        System.out.println("\n### MENU DE DEVOLUÇÃO ###");

        aluguelController.listarAlugueis();

        try{
            System.out.print("Veículo a ser devolvido (placa): ");
            String placaDesejada = scanner.nextLine();
            Veiculo veiculoDevolvido = veiculoController.buscarVeiculoPorPlaca(placaDesejada);

            if (veiculoDevolvido == null) {
                throw new IllegalArgumentException("Veículo não cadastrado.");
            }

            Aluguel aluguel = aluguelController.buscarAluguelPorVeiculo(veiculoDevolvido);

            System.out.print("Informe a data de devolução (dd/mm/aaaa): ");
            StringBuilder dataDevolucao = new StringBuilder(scanner.nextLine());
            System.out.print("Informe o horário de devolução (hh:mm): ");
            dataDevolucao.append(" " + scanner.nextLine());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime dataFim = LocalDateTime.parse(dataDevolucao, formatter);


            devolucaoController.registrarDevolucao(veiculoDevolvido, aluguel, dataFim);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
