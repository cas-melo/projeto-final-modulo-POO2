package services;

import models.Aluguel;
import models.Cliente;
import models.Veiculo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AluguelService {

    private Map<Cliente, List<Veiculo>> alugueis;

    public AluguelService() {
        this.alugueis = new HashMap<>();
    }

    public void alugarVeiculo(Cliente cliente, Veiculo veiculo) {
        if (veiculo.isDisponivel()) {
            List<Veiculo> veiculosAlugados = alugueis.getOrDefault(cliente, new ArrayList<>());
            veiculosAlugados.add(veiculo);
            alugueis.put(cliente, veiculosAlugados);
            veiculo.setDisponivel(false);
        } else {
            System.out.println("Veículo não está disponível");
        }
    }

    public void devolverVeiculo(Cliente cliente, Veiculo veiculo) {
        if (alugueis.containsKey(veiculo) && alugueis.get(cliente).contains(veiculo)) {
            veiculo.setDisponivel(true);
            alugueis.get(cliente).remove(veiculo);
        }
    }
}