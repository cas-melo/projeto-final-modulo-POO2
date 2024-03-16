package models;

public abstract class Cliente {
    private String nome;

    public Cliente(String nome, Veiculo veiculoAlugado) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String getDocumento();

    public abstract String getTipoDocumento();
}
