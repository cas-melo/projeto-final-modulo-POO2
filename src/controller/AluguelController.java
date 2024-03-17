package controller;
import models.*;
import services.AluguelService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

            AluguelService aluguelService = new AluguelService();
            aluguelService.alugarVeiculo(cliente, veiculo);

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

    public void listarAlugueis() {
        System.out.println("\n### LISTA ALUGUÉIS ATIVOS ###");

        for (Aluguel aluguel : alugueis) {
            String dataInicioFormat = formatarLocalDateTime(aluguel.getDataInicio());

            System.out.println("\nModelo: " + aluguel.getVeiculo().getMarca() + " " + aluguel.getVeiculo().getModelo() +
                    " | Placa: " + aluguel.getVeiculo().getPlaca() + " | Tipo: " + aluguel.getVeiculo().getTipo());
            System.out.println("Cliente: " + aluguel.getCliente().getNome() + " | " +
                    aluguel.getCliente().getTipoDocumento() + ": " + aluguel.getCliente().getDocumento());
            System.out.println("Local: " + aluguel.getCidade() + " | Data de início: " + dataInicioFormat);
        }
    }

    public String formatarLocalDateTime(LocalDateTime dataHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHora.format(formatter);
    }
}
