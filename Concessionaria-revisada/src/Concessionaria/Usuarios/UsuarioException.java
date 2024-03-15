package Concessionaria.Usuarios;

public class UsuarioException extends Exception {
    public UsuarioException() {
        super("Usuário não encontrado!");
    }
}
