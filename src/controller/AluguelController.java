package controller;
import models.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AluguelController {

    private List<Aluguel> alugueis;
    private VeiculoController veiculoController;

    public AluguelController() {
        this.alugueis = new ArrayList<>();
        this.veiculoController = veiculoController;
    }

    public void realizarAluguel(Veiculo veiculo, Cliente cliente, String cidade) {
        if (veiculo.isDisponivel()) {
            Aluguel aluguel = new Aluguel(veiculo, cliente, cidade, LocalDateTime.now());
            veiculo.setDisponivel(false);
            cliente.setVeiculoAlugado(veiculo);
            veiculo.setCliente(cliente);
            alugueis.add(aluguel);
        } else {
            System.out.println("Veículo não disponível para aluguel.");
        }
    }

    public List<Aluguel> listarAlugueis() {
        return this.alugueis;
    }
}
