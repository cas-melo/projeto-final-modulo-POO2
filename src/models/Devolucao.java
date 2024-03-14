package models;

import java.time.LocalDateTime;

public class Devolucao extends Aluguel{
    private LocalDateTime dataFim;

    private double valorTotal;

    public Devolucao(Veiculo veiculo, Cliente cliente, String cidade, LocalDateTime dataInicio, LocalDateTime dataFim, double valorTotal) {
        super(veiculo, cliente, cidade, dataInicio);
        this.dataFim = dataFim;
        this.valorTotal = valorTotal;
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
}
