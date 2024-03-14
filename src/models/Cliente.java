package models;

public abstract class Cliente {
    private String nome;
    private Veiculo veiculoAlugado;

    public Cliente(String nome, Veiculo veiculoAlugado) {
        this.nome = nome;
        this.veiculoAlugado = veiculoAlugado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Veiculo getVeiculoAlugado() {
        return veiculoAlugado;
    }

    public void setVeiculoAlugado(Veiculo veiculoAlugado) {
        this.veiculoAlugado = veiculoAlugado;
    }

    public abstract String getDocumento();
}
