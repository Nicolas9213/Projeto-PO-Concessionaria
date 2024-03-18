package Concessionaria.Exceptions;

public class VeiculoNaoEncontradoException extends Exception {
    public VeiculoNaoEncontradoException(String codigo) {
        super("Veículo de código " + codigo + " não foi encontrado!");
    }
}
