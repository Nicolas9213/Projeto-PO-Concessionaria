package Concessionaria;

import Concessionaria.Usuarios.*;
import Concessionaria.Veiculos.*;

import java.util.Scanner;

import static Concessionaria.Veiculos.Veiculo.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private static final Usuario gerente = new Gerente("Nicolas", "12", "123", 10000);

    private static final Usuario cliente = new Cliente("Ramon", "1234", "234", "345");

    private static final Veiculo veiculo1 = new Carro("Nissan", "121", "1212", true,
            "disponivel", 0, "Gtr R35", 2023, 780000);

    private static final Veiculo veiculo2 = new Carro("Toyota", "122", "1221", true,
            "disponivel", 0, "Mk5", 2023, 880000);

    private static final Veiculo veiculo3 = new Carro("Mazda", "121", "122", false,
            "disponivel", 250000, "Rx-7", 1997, 980000);

    private static Usuario usuarioLogado;

    public static void main(String[] args) {
        Usuario.addUsuario(gerente);
        Usuario.addUsuario(cliente);
        Veiculo.addVeiculo(veiculo1);
        Veiculo.addVeiculo(veiculo2);
        Veiculo.addVeiculo(veiculo3);

        do {
            menuPrincipal();

        } while (true);
    }

    public static void menuPrincipal() {
        System.out.println("""
                1 - Login
                2 - Cadastro
                3 - Ver estoque
                4 - Ver detalhes de um veiculo
                """);


        if (usuarioLogado != null) {
            System.out.println("5 - Ver meus veiculos");
            if (usuarioLogado instanceof Funcionario) {
                System.out.println("""
                        6 - Vender veiculo
                        7 - Procurar cliente
                        8 - Ver Pagamento
                        """);

                if (usuarioLogado instanceof Gerente) {
                    System.out.println("""
                            9 - Cadastrar veiculo
                            10 - Remover veiculo
                            11 - Editar veiculo
                            12 - Adicionar Cliente/Vendedor
                            13 - Remover Cliente/Vendedor
                            14 - Editar Cliente/Vendedor
                            15 - Ver vendedores
                            16 - Ver clientes
                            17 - Ver pagamento dos vendedores
                            18 - Ver pagamento de um vendedor
                            """);
                }
            }

            System.out.println("0 - Sair");
        }

        int escolha = sc.nextInt();
        switch (escolha) {
            case 0 -> sair();
            case 1 -> login();
            case 2 -> cadastroUsuario();
            case 3 -> verEstoque();
            case 4 -> verUmVeiculo();
        }

        if (usuarioLogado != null) {
            if (escolha == 5) {
                verMeusVeiculos();
            }

            if (usuarioLogado instanceof Funcionario) {
                switch (escolha) {
                    case 6 -> venderUmVeiculo();
                    case 7 -> procurarCliente();
                    case 8 -> verPagamento();
                }

                if (usuarioLogado instanceof Gerente) {
                    switch (escolha) {
                        case 9 -> cadastrarVeiculo();
                        case 10 -> removerVeiculo();
                        case 11 -> editarVeiculo();
                        case 12 -> cadastrarUsuario();
                        case 13 -> removerUsuario();
                        case 14 -> editarUsuario();
                        case 15 -> verVendedores();
                        case 16 -> verClientes();
                        case 17 -> verPagamentosDosVendedores();
                        case 18 -> verPagamentoDeUmVendedor();
                    }
                }
            }

        }

    }

    private static void verPagamentoDeUmVendedor() {

    }

    private static void verPagamentosDosVendedores() {

    }

    private static void verClientes() {

    }

    private static void verVendedores() {

    }

    private static void removerUsuario() {

    }

    private static void cadastrarUsuario() {

    }

    private static void editarVeiculo() {

    }

    private static void removerVeiculo() {

    }

    private static void cadastrarVeiculo() {

    }

    private static void editarUsuario() {

    }

    private static void verPagamento() {

    }

    private static void procurarCliente() {

    }

    private static void venderUmVeiculo() {

    }

    private static void verMeusVeiculos() {

    }

    private static void sair() {
        usuarioLogado = null;
    }


    private static void verUmVeiculo() {
        System.out.println("Digite o código do veículo: ");
        String codigo = sc.next();

        Veiculo veiculo = getVeiculo(codigo);

        if (veiculo != null) {
            System.out.println("Detalhes do veículo: ");
            System.out.println(veiculo.toString());
        } else {
            System.out.println("Veículo não encontrado");
        }
    }

    private static void verEstoque() {
        for (Veiculo veiculo : Veiculo.getVeiculos()) {
            System.out.println(veiculo.getInformacoesEstoque());
        }
    }

    private static void login() {
        System.out.println("Digite o cpf: ");
        String cpf = sc.next();
        System.out.println("Digite a senha: ");
        String senha = sc.next();

        usuarioLogado = Usuario.login(cpf, senha);
    }


    public static void cadastroUsuario() {
        System.out.println("Nome: ");
        String nome = sc.next();
        System.out.println("Cpf: ");
        String cpf = sc.next();
        System.out.println("Senha: ");
        String senha = sc.next();
        System.out.println("Cnh: ");
        String cnh = sc.next();

        Usuario usuario = new Cliente(nome, cpf, senha, cnh);
        Usuario.addUsuario(usuario);
    }
}