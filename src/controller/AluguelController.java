package controller;
import models.*;
import models.veiculos.*;

import java.time.LocalDateTime;

public class AluguelController {
    private Veiculo veiculo;
    private Cliente cliente;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private double valorTotal;

    public AluguelController(Veiculo veiculo, Cliente cliente, LocalDateTime dataInicio, LocalDateTime dataFim, double valorTotal) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    private void calcularValorTotal(Cliente cliente) {
        // TODO
    }
}