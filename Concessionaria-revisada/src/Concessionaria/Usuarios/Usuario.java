package Concessionaria.Usuarios;

import Concessionaria.Veiculos.Veiculo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Usuario {

    protected static final ArrayList<Usuario> usuarios = new ArrayList<>();
    private static final ArrayList<Veiculo> meusVeiculos = new ArrayList<>();

    private String nome;
    protected String cpf;

    public Usuario(String nome, String usuario) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String verMeusVeiculos() {
        return Veiculo.verVeiculos().toString();
    }

    public static void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static List<Usuario> verUsuarios() { // O método poderia ser getUsuarios()
        return Collections.unmodifiableList(usuarios);
    }

    /* Método login pode ser implementado na classe Main
    public static Usuario login(String cpf, String senha) {
        return null;
    }
    */
}
