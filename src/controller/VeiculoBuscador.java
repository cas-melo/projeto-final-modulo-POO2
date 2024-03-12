package controller;

import models.veiculos.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VeiculoBuscador {

    public List<Veiculo> buscarPorNome(List<Veiculo> veiculos, String nome) {
        if (veiculos == null || nome == null) {
            return List.of(); // Retorna uma lista vazia se os argumentos forem nulos
        }

        String nomeBusca = nome.toLowerCase();
        return veiculos.stream()
                .filter(veiculo -> veiculo.getNome().toLowerCase().contains(nomeBusca))
                .collect(Collectors.toList());
    }
}
