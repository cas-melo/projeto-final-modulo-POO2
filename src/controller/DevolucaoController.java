package controller;
import models.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DevolucaoController {
    private List<Devolucao> devolucoes;
    AluguelController aluguelController;

    public DevolucaoController(AluguelController aluguelController) {
        this.devolucoes = new ArrayList<>();
        this.aluguelController = aluguelController;
    }


    private void calcularValorTotal() {
        // TODO
    }

    public void registrarDevolucao(Veiculo veiculo, Aluguel aluguel, LocalDateTime dataFim){
        //TODO: valorTotal = calcularValorTotal();

        if (veiculo.isDisponivel()){
            System.out.println("Veículo não pode ser devolvido pois não está alugado.");
            return;
        }

        Devolucao devolucao = new Devolucao(veiculo, aluguel.getCliente(), aluguel.getCidade(),
        aluguel.getDataInicio(), dataFim, 200); //TODO: substituir 200 p/ valorTotal

        aluguelController.removerAluguel(aluguel);

        veiculo.setDisponivel(true);
        veiculo.setCliente(null);

        Cliente cliente = aluguel.getCliente();
        cliente.setVeiculoAlugado(null);

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
