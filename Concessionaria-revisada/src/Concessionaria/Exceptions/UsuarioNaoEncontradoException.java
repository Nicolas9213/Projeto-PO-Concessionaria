package Concessionaria.Exceptions;

public class UsuarioNaoEncontradoException extends Exception {
    public UsuarioNaoEncontradoException(String cpf) {
        super("O usuário de CPF " + cpf + " não foi encontrado!");
    }

    public UsuarioNaoEncontradoException() {
        super("Usuário não encontrado!");
    }
}
