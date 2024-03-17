package view;

import controller.VeiculoController;
import exceptions.VeiculoNaoEncontradoException;
import models.Veiculo;
import util.GeradorPlaca;
import util.TipoVeiculo;

import java.util.Scanner;

public class EdicaoVeiculoView {

    private Scanner scanner;

    private VeiculoController veiculoController;

    public EdicaoVeiculoView(VeiculoController veiculoController) {
        this.scanner = new Scanner(System.in);
        this.veiculoController = veiculoController;
    }

    public void exibirEdicaoVeiculo() {
        System.out.println("\n### Edição de Veículo ###");

        veiculoController.listarVeiculos();

        try {

            System.out.print("Digite a placa do veículo que deseja alterar: ");
            String placa = scanner.nextLine();

            Veiculo veiculo = veiculoController.buscarVeiculoPorPlaca(placa);

            if (veiculo == null) {
                throw new VeiculoNaoEncontradoException("Placa " + placa + "não encontrada.");
            }


            if (!GeradorPlaca.validarPlaca(placa)) {
                throw new IllegalArgumentException("Placa inválida!");
            }


            System.out.print("Digite o novo nome de marca: ");
            String marca = scanner.nextLine();
            if (marca.isEmpty() || marca.isBlank()) {
                throw new IllegalArgumentException("Marca inválida!");
            }


            System.out.print("Digite o novo nome de modelo: ");
            String modelo = scanner.nextLine();
            if (modelo.isEmpty() || modelo.isBlank()) {
                throw new IllegalArgumentException("Modelo inválido!");
            }


            System.out.print("Digite o novo tipo de veículo: ");
            TipoVeiculo tipo = veiculoController.solicitarTipoVeiculo();


            veiculoController.alterarVeiculo(placa, marca, modelo, tipo);

            System.out.println("Veículo alterado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (VeiculoNaoEncontradoException veiculoNaoEncontradoException) {
            System.out.println("Placa não encontrada. Tente novamente!");
        } catch (Exception e) {
            System.out.println("Erro inesperado. Entre em contato com o suporte.");
            e.printStackTrace();

        }
    }

}
