package view;
import controller.AluguelController;
import controller.DevolucaoController;
import controller.VeiculoController;
import models.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void exibirMenuDevolucao() {
        System.out.println("\n### MENU DE DEVOLUÇÃO ###");

        aluguelController.listarAlugueis();

        try {
            System.out.print("Veículo a ser devolvido (placa): ");
            String placaDesejada = scanner.nextLine();
            Veiculo veiculoDevolvido = veiculoController.buscarVeiculoPorPlaca(placaDesejada);

            if (veiculoDevolvido == null) {
                throw new IllegalArgumentException("Veículo não cadastrado.");
            }

            Aluguel aluguel = aluguelController.buscarAluguelPorVeiculo(veiculoDevolvido);

            String dataDevolucao = obterDataHoraDevolucao("Informe a data e hora de devolução (dd/mm/aaaa hh:mm): ");
            LocalDateTime dataFim = LocalDateTime.parse(dataDevolucao, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

            devolucaoController.registrarDevolucao(veiculoDevolvido, aluguel, dataFim);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private String obterDataHoraDevolucao(String mensagem) {
        String dataHora;

        do {
            System.out.print(mensagem);
            dataHora = scanner.nextLine();
        } while (!validarDataHora(dataHora));

        return dataHora;
    }

    private boolean validarDataHora(String dataHora) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime.parse(dataHora, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
