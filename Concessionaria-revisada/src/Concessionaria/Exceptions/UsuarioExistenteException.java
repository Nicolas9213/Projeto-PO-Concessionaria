package Concessionaria.Exceptions;

public class UsuarioExistenteException extends Exception {
    public UsuarioExistenteException(String usuario) {
        super("Usuário já existe na base de dados");
    }
}
