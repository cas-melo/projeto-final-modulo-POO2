package controller;
import models.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class DevolucaoController {
    private List<Devolucao> devolucoes;
    AluguelController aluguelController;

    public DevolucaoController(AluguelController aluguelController) {
        this.devolucoes = new ArrayList<>();
        this.aluguelController = aluguelController;
    }




    public void registrarDevolucao(Veiculo veiculo, Aluguel aluguel, LocalDateTime dataFim){

        long totalDias = DAYS.between(aluguel.getDataInicio(), dataFim);
        Desconto desconto = DescontoHelper.obterDesconto(aluguel.getCliente());
        Diaria diaria = new Diaria(totalDias, veiculo.getTipo(), desconto);
        double valorTotal = diaria.getValorTotal();

        if (veiculo.isDisponivel()){
            System.out.println("Veículo não pode ser devolvido pois não está alugado.");
            return;
        }

        Devolucao devolucao = new Devolucao(veiculo, aluguel.getCliente(), aluguel.getCidade(),
        aluguel.getDataInicio(), dataFim, valorTotal);
        AtualizadorEstado atualizador = new AtualizadorEstado();

        aluguelController.removerAluguel(aluguel);

        atualizador.atualizarEstadoVeiculoDisponivel(veiculo);
        atualizador.atualizarEstadoClienteDevolveu(aluguel.getCliente());

 
        devolucoes.add(devolucao);
        System.out.println("Devolução registrada com sucesso!");
    }

    public String formatarLocalDateTime(LocalDateTime dataHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHora.format(formatter);
    }

    public List<Devolucao> listarDevolucoes() {
        return this.devolucoes;
    }
}
