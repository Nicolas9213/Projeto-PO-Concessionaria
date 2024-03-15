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
            true, 0, "Gtr R35", 2023, 780000);

    private static final Veiculo veiculo2 = new Carro("Toyota", "122", "1221", true,
            true, 0, "Mk5", 2023, 880000);

    private static final Veiculo veiculo3 = new Carro("Mazda", "121", "122", false,
            true, 250000, "Rx-7", 1997, 980000);

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
                    case 7 -> exibirCliente();
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
                        case 17 -> verPagamentosVendedores();
                        case 18 -> verPagamentoVendedor();
                    }
                }
            }

        }

    }

    private static void verPagamentoVendedor() {

    }

    private static void verPagamentosVendedores() {

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
        Veiculo novoVeiculo = menuCadastroVeiculo();

    }

    private static void removerVeiculo() {
        Veiculo veiculo = procurarVeiculo();
        remVeiculo(veiculo);
    }

    private static void cadastrarVeiculo() {
        Veiculo veiculoGenerico = menuCadastroVeiculo();

        if (veiculoGenerico != null) {
            Veiculo.addVeiculo(veiculoGenerico);
            System.out.println("O veiculo foi cadastrado com sucesso!");
        }else {
            System.out.println("Não foi possivel cadastrar o veiculo!");
        }
    }

    private static Veiculo menuCadastroVeiculo() {
        System.out.println("Digite o tipo de veículo que deseja cadastrar: ");
        System.out.println("""
                1- Carro
                2- Moto
                3- Caminhão
                """);
        int tipoVeiculo = sc.nextInt();

        System.out.println("Informe a marca do veículo:");
        String marca = sc.nextLine();

        System.out.println("Informe o modelo do veículo:");
        String modelo = sc.nextLine();

        System.out.println("Informe a placa do veículo:");
        String placa = sc.nextLine();

        System.out.println("Informe o código do veículo:");
        String codigo = sc.nextLine();

        System.out.println("O veículo é novo? (true/false):");
        boolean novo = sc.nextBoolean();

        System.out.println("Informe o status do veículo: (Disponivel/Vendido)");
        String status = sc.nextLine();

        System.out.println("Informe a quilometragem do veículo:");
        int quilometragem = sc.nextInt();

        System.out.println("Informe o ano do veículo:");
        int ano = sc.nextInt();

        System.out.println("Informe o preço do veículo:");
        float preco = sc.nextFloat();

        Veiculo veiculoGenerico = null;

        switch (tipoVeiculo) {
            case 1:
                veiculoGenerico = new Carro(marca, placa, codigo, novo, true, quilometragem, modelo, ano, preco);
                break;
            case 2:
                veiculoGenerico = new Moto(marca, placa, codigo, novo, true, quilometragem, modelo, ano, preco);
            case 3:
                System.out.println("Digite o peso máximo do veículo: ");
                float pesoMaximo = sc.nextFloat();

                System.out.println("Digite o comprimento do veículo: ");
                int comprimento = sc.nextInt();

                System.out.println("Digite a quantidade de rodas do veículo: ");
                int qntdRodas = sc.nextInt();
                veiculoGenerico = new Caminhao(marca, placa, codigo, novo, true, quilometragem, modelo, ano, preco, pesoMaximo, comprimento, qntdRodas);
        }
        return veiculoGenerico;
    }

    private static void editarUsuario() {

    }

    private static void verPagamento() {
        System.out.println("Pagamento: " + ((Funcionario) usuarioLogado).verPagamento());
    }

    private static void exibirCliente() {
        Usuario cliente = procurarCliente();
        System.out.println(cliente.toString());
    }

    private static Usuario procurarCliente() {
        System.out.println("Insira o CPF do cliente: ");
        String cpf = sc.next();
        Usuario cliente = Usuario.getUsuario(cpf);
        if (!(cliente instanceof Cliente)) {
            System.out.println("Cliente não consta na base de dados");
        }
        return cliente;
    }

    private static Veiculo procurarVeiculo() {
        System.out.println("Digite o código do veículo: ");
        String codigo = sc.next();
        Veiculo veiculo = getVeiculo(codigo);
        if (veiculo == null) {
            System.out.println("Veículo não existe");
        }
        return veiculo;
    }

    private static void venderUmVeiculo() {
        Veiculo veiculo = procurarVeiculo();
        Usuario cliente = procurarCliente();

        if (veiculo.isVendido()) {
            System.out.println("O veículo não está disponível");
        }

        Venda venda = new Venda(usuarioLogado.getCpf(), cliente, veiculo);

        ((Funcionario) usuarioLogado).addVenda(venda);
        veiculo.setStatus(false);
        cliente.addVeiculo(veiculo);
        System.out.println("Venda efetuada!");
    }

    private static void verMeusVeiculos() {

    }

    private static void sair() {
        usuarioLogado = null;
    }

    private static void verUmVeiculo() {
        Veiculo veiculo = procurarVeiculo();

        System.out.println("Detalhes do veículo: ");
        System.out.println(veiculo.toString());
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
        try {
            usuarioLogado = Usuario.login(cpf, senha);

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
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