package Concessionaria.Usuarios;

public class SenhaIncorretaException extends Exception {
    public SenhaIncorretaException() {
        super("Senha incorreta!");
    }
}