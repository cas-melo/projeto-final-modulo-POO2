package controller;
import models.Cliente;
import models.Veiculo;
import util.TipoVeiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VeiculoController {

    private BuscadorController veiculoBuscador;
    private List<Veiculo> veiculos;

    public VeiculoController() {
        this.veiculoBuscador = new BuscadorController();
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(String marca, String modelo, TipoVeiculo tipo, Cliente cliente) {
        Veiculo novoVeiculo = new Veiculo(marca, modelo, tipo, cliente);

        if (placaJaExistente(novoVeiculo.getPlaca())) {
            System.out.println("Erro: Placa já cadastrada.");
            return;
        }

        System.out.println("Placa cadastrada automaticamente");
        this.veiculos.add(novoVeiculo);
        System.out.println("Veículo cadastrado com sucesso!\n");
    }

    public void alterarVeiculo(String placa, String marca, String modelo, TipoVeiculo tipo) {
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);
        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);
        veiculo.setTipo(tipo);

    }

    private boolean placaJaExistente(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return true;
            }
        }
        return false;
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public List<Veiculo> listarVeiculos() {
        return this.veiculos;
    }

    public List<Veiculo> buscarVeiculosPorNome(String nome) {
        return veiculoBuscador.buscarPorNome(veiculos, nome);
    }

    public TipoVeiculo solicitarTipoVeiculo(){
        TipoVeiculo tipo = null;
        boolean tipoValido = false;
        Scanner scanner = new Scanner(System.in);

        while (!tipoValido) {

            try {
                System.out.print("Tipo do veículo (PEQUENO, MEDIO ou SUV): ");
                String tipoStr = scanner.next().toUpperCase();
                tipo = TipoVeiculo.valueOf(tipoStr);
                tipoValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de veículo inválido. Por favor, insira PEQUENO, MEDIO ou SUV.");
                scanner.nextLine();
            }
        }

        return tipo;
    }
}
