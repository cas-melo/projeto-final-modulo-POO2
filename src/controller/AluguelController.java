package controller;
import models.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AluguelController {

    private List<Aluguel> alugueis;
    private VeiculoController veiculoController;

    public AluguelController(VeiculoController veiculoController) {
        this.alugueis = new ArrayList<>();
        this.veiculoController = veiculoController;
    }

    public void realizarAluguel(Veiculo veiculo, Cliente cliente, LocalDateTime dataFim, double valorTotal) {
        if (veiculo.isDisponivel()) {
            Aluguel aluguel = new Aluguel(veiculo, cliente, LocalDateTime.now(), dataFim, valorTotal);
            veiculo.setDisponivel(false);
            cliente.setVeiculoAlugado(veiculo);
            alugueis.add(aluguel);
        } else {
            System.out.println("Veículo não disponível para aluguel.");
        }
    }

    private void calcularValorTotal(Veiculo veiculo) {
        // TODO

    }

    public List<Aluguel> listarAlugueis() {
        return this.alugueis;
    }
}
