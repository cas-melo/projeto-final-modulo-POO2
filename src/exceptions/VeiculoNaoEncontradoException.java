package exceptions;

public class VeiculoNaoEncontradoException extends Exception {

    public VeiculoNaoEncontradoException(String message) {
        super(message);
    }

    public VeiculoNaoEncontradoException() {
        super("Veículo não encontado.");
    }
}
