package services;

import models.Aluguel;
import models.Cliente;
import models.Veiculo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AluguelService {

    private static Map<Cliente, List<Veiculo>> alugueis;

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

    public void alterarClienteAluguel(Cliente clienteAntigo, Cliente novoCliente) {
        for (Map.Entry<Cliente, List<Veiculo>> entry : alugueis.entrySet()) {
            if (entry.getKey().equals(clienteAntigo)) {
                // Atualizar o cliente associado a cada aluguel
                List<Veiculo> veiculosAlugados = entry.getValue();
                alugueis.remove(clienteAntigo);
                alugueis.put(novoCliente, veiculosAlugados);
            }
        }
    }

    public static Cliente getClientePorVeiculo(Veiculo veiculo) {
        for (Map.Entry<Cliente, List<Veiculo>> entry : alugueis.entrySet()) {
            if (entry.getValue().contains(veiculo)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static List<Veiculo> getVeiculosPorCliente(Cliente cliente) {
        List<Veiculo> veiculosDoCliente = new ArrayList<>();

        for (Map.Entry<Cliente, List<Veiculo>> entry : alugueis.entrySet()) {
            if (entry.getKey().equals(cliente)) {
                veiculosDoCliente.addAll(entry.getValue());
                return veiculosDoCliente;
            }
        }
        return veiculosDoCliente;
    }
}
