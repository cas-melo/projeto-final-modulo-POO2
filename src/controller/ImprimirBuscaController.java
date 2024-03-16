package controller;

import models.Veiculo;

import java.util.List;

import static java.lang.StringTemplate.STR;

public class ImprimirBuscaController {

    public void imprimirBusca(List<Veiculo> veiculos) {
        if (veiculos == null || veiculos.isEmpty()) {
            System.out.println("Nenhum veículo encontrado.");
            return;
        }

        System.out.println("Veículos encontrados:");
        for (Veiculo veiculo : veiculos) {
            System.out.println(STR."Nome: \{veiculo.getModelo()}, Placa: \{veiculo.getPlaca()}");
        }
    }
}
