package controller;
import models.*;
import services.AluguelService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;



public class DevolucaoController {
    private List<Devolucao> devolucoes;
    AluguelController aluguelController;

    public DevolucaoController(AluguelController aluguelController) {
        this.devolucoes = new ArrayList<>();
        this.aluguelController = aluguelController;
    }

    public void registrarDevolucao(Veiculo veiculo, Aluguel aluguel, LocalDateTime dataFim) {

        long totalHoras = ChronoUnit.MINUTES.between(aluguel.getDataInicio(), dataFim);
        int totalDias = DiariaHelper.converterMinutosEmDiarias(totalHoras);
        Desconto desconto = DescontoHelper.obterDesconto(aluguel.getCliente());
        Diaria diaria = new Diaria(totalDias, veiculo.getTipo(), desconto);
        double valorTotal = diaria.getValorTotal();

        if (veiculo.isDisponivel()) {
            System.out.println("Veículo não pode ser devolvido pois não está alugado.");
            return;
        }

        Devolucao devolucao = new Devolucao(veiculo, aluguel.getCliente(), aluguel.getCidade(),
                aluguel.getDataInicio(), dataFim, valorTotal);

        AluguelService aluguelService = new AluguelService();
        aluguelService.devolverVeiculo(aluguel.getCliente(), veiculo);

        aluguelController.removerAluguel(aluguel);
        devolucoes.add(devolucao);
        System.out.println("Devolução registrada com sucesso!");
    }

    public String formatarLocalDateTime(LocalDateTime dataHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHora.format(formatter);
    }

    public void listarDevolucoes() {
        System.out.println("\n### LISTA DE ALUGUÉIS FINALIZADOS ###");

        for (Devolucao devolucao : devolucoes) {
            String dataInicioFormat = formatarLocalDateTime(devolucao.getDataInicio());
            String dataFimFormat = formatarLocalDateTime(devolucao.getDataFim());

            System.out.println("\nModelo: " + devolucao.getVeiculo().getMarca() + " " + devolucao.getVeiculo().getModelo() +
                    " | Placa: " + devolucao.getVeiculo().getPlaca() + " | Tipo: " + devolucao.getVeiculo().getTipo());

            System.out.println("Cliente: " + devolucao.getCliente().getNome() + " | " +
                    devolucao.getCliente().getTipoDocumento() + ": " + devolucao.getCliente().getDocumento());

            System.out.println("Local: " + devolucao.getCidade() + " | Data de início: " + dataInicioFormat +
                    " | Data do fim: " + dataFimFormat + " | Valor: " + devolucao.getValorTotal());
        }
    }
}
