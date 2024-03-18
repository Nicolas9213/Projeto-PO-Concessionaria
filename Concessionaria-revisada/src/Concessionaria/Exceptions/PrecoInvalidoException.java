package Concessionaria.Exceptions;

public class PrecoInvalidoException extends Exception {
    public PrecoInvalidoException() {
        super("Preço inválido! O valor deve ser maior que 0");
    }
}
