package controller;
import models.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AluguelController {

    private List<Aluguel> alugueis;

    public AluguelController() {
        this.alugueis = new ArrayList<>();
    }

    public void realizarAluguel(Veiculo veiculo, Cliente cliente, String cidade) {
        if (veiculo.isDisponivel()) {

            Aluguel aluguel = new Aluguel(veiculo, cliente, cidade, LocalDateTime.now());
            AtualizadorEstado atualizador = new AtualizadorEstado();

            atualizador.atualizarEstadoVeiculoIndisponivel(veiculo, cliente);
            atualizador.atualizarEstadoClienteAlugou(veiculo, cliente);


            this.alugueis.add(aluguel);
            System.out.println("Aluguel realizado com sucesso!");
        } else {
            System.out.println("Veículo não disponível para aluguel.");
        }
    }

    public void removerAluguel(Aluguel aluguel){
        this.alugueis.remove(aluguel);
    }

    public Aluguel buscarAluguelPorVeiculo(Veiculo veiculo) {
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getVeiculo().equals(veiculo)) {
                return aluguel;
            }
        }
        return null;
    }

    public List<Aluguel> listarAlugueis() {
        return this.alugueis;
    }
}
