package controller;
import models.Cliente;
import models.Veiculo;
import services.AluguelService;
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

    public void adicionarVeiculo(String marca, String modelo, TipoVeiculo tipo) {
        Veiculo novoVeiculo = new Veiculo(marca, modelo, tipo);

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
                System.out.print("Tipo de veículo inválido. Por favor, insira PEQUENO, MEDIO ou SUV: ");
                scanner.nextLine();
            }
        }

        return tipo;
    }

    public List<Veiculo> listaDeVeiculos() {
        return this.veiculos;
    }

    public void listarVeiculos() {
        System.out.println("Veículos cadastrados: ");
        VeiculoController veiculoController = new VeiculoController();
        for (Veiculo veiculo : veiculoController.listaDeVeiculos()) {
            System.out.println("\nModelo: " + veiculo.getMarca() + " " + veiculo.getModelo() +
                    " | Placa: " + veiculo.getPlaca() + " | Tipo: " + veiculo.getTipo());

            Cliente cliente = AluguelService.getClientePorVeiculo(veiculo);
            if (cliente != null){
                System.out.println("Alugado | Cliente: " + cliente.getNome() + "| " + cliente.getTipoDocumento()
                        + ": " + cliente.getDocumento());
            }
            else {
                System.out.println("Disponível");
            }
        }

    }

    public List<Veiculo> buscarVeiculosPorNome(String nome) {
        return veiculoBuscador.buscarPorNome(veiculos, nome);
    }

}
