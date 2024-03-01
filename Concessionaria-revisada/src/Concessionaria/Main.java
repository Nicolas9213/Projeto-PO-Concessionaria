package Concessionaria;

import Concessionaria.Usuarios.Cliente;
import Concessionaria.Usuarios.Gerente;
import Concessionaria.Usuarios.Usuario;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private static final Usuario gerente = new Gerente("Nicolas", "123.123.123-12", "123", 10000);

    private static Usuario usuarioLogado;

    public static void main(String[] args) {
        Usuario.addUsuario(gerente);

        do {
            System.out.println("Bem vindo à Concessionária do Nicolas");
            System.out.println("""
                    1- Cadastro de Usuário
                    2- Login
                    3- Sair"
                    """);
            int escolha = sc.nextInt();

            switch (escolha) {
                case 1 -> cadastroUsuario();
                case 2 -> login();
                case 3 -> System.exit(0);
            }
        } while (usuarioLogado == null);
    }


    public static void cadastroUsuario() {
        System.out.println("Nome: ");
        String nome = sc.next();
        System.out.println("Usuário: ");
        String cpf = sc.next();
        System.out.println("Senha: ");
        String cnh = sc.next();

        Usuario usuario = new Cliente(nome, cpf);
        Usuario.addUsuario(usuario);
    }
}