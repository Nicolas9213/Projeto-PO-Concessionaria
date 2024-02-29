package Concessionaria.Usuarios;

import Concessionaria.Veiculos.Veiculo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Usuario {

    protected static final ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Veiculo> meusVeiculos = new ArrayList<>();

    private String nome;
    private String cpf;
    private String senha;

    public Usuario(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    protected void addVeiculos(Veiculo veiculo) {
        Veiculo.addVeiculo(veiculo);
    }

    protected List<Veiculo> verMeusVeiculos() {
        return Collections.unmodifiableList(meusVeiculos);
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public static void editarUsuario(Usuario novoUsuario, String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(novoUsuario.cpf)) {
                usuarios.set(usuarios.indexOf(usuario), novoUsuario);
            }
        }
    }

    public static Usuario getUsuario(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    public static List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }

    public static void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static Usuario login(String cpf, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public String toString() {
        return "Usuario{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
