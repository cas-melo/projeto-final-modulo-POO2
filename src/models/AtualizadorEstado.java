package models;

public class AtualizadorEstado {

    public void atualizarEstadoVeiculoDisponivel(Veiculo veiculo) {
        veiculo.setDisponivel(true);
        veiculo.setCliente(null);
    }

    public void atualizarEstadoVeiculoIndisponivel(Veiculo veiculo, Cliente cliente) {
        veiculo.setDisponivel(false);
        veiculo.setCliente(cliente);
    }

    public void atualizarEstadoClienteAlugou(Veiculo veiculo, Cliente cliente) {
        cliente.setVeiculoAlugado(veiculo);
    }

    public void atualizarEstadoClienteDevolveu(Cliente cliente){
        cliente.setVeiculoAlugado(null);
    }
}
