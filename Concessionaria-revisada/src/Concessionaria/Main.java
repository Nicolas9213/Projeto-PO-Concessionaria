package Concessionaria;

import Concessionaria.Exceptions.SenhaIncorretaException;
import Concessionaria.Exceptions.UsuarioNaoEncontradoException;
import Concessionaria.Exceptions.VeiculoExistenteException;
import Concessionaria.Exceptions.VeiculoNaoEncontradoException;
import Concessionaria.Usuarios.*;
import Concessionaria.Veiculos.*;

import java.util.Scanner;

import static Concessionaria.Veiculos.Veiculo.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private static final Usuario gerente = new Gerente("Nicolas", "12", "123", 10000);
    private static final Usuario funcionario = new Vendedor("Vendedor da Silva", "1", "13", 100);
    private static final Usuario cliente = new Cliente("Ramon", "1234", "234", "345");
    private static final Veiculo veiculo1 = new Carro("Nissan", "121", "1212", true,
            true, 0, "Gtr R35", 2023, 780000);
    private static final Veiculo veiculo2 = new Carro("Toyota", "122", "1221", true,
            true, 0, "Mk5", 2023, 880000);
    private static final Veiculo veiculo3 = new Carro("Mazda", "121", "122", false,
            true, 250000, "Rx-7", 1997, 980000);
    private static Usuario usuarioLogado;

    public static void main(String[] args) throws VeiculoNaoEncontradoException, VeiculoExistenteException {
        Usuario.addUsuario(gerente);
        Usuario.addUsuario(funcionario);
        Usuario.addUsuario(cliente);
        Veiculo.addVeiculo(veiculo1);
        Veiculo.addVeiculo(veiculo2);
        Veiculo.addVeiculo(veiculo3);

        do {
            menuPrincipal();

        } while (true);
    }

    public static void menuPrincipal() throws VeiculoNaoEncontradoException {
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
        String cpf = pedirCpf();
        Usuario vendedor = Usuario.getUsuario(cpf);

        if (vendedor == null) {
            System.out.println("Vendedor não encontrado!");
            return;
        }
        if (!(vendedor instanceof Vendedor)) {
            System.out.println("Usuário não é um vendedor!");
            return;
        }

        System.out.println(((Gerente) usuarioLogado).verPagamentoUmVendedor(cpf));
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
        Veiculo veiculoAntigo = procurarVeiculo();
        if (veiculoAntigo != null) {
            Veiculo novoVeiculo = menuCadastroVeiculo();
            if (novoVeiculo != null) {
                ((Gerente) usuarioLogado).editarVeiculo(veiculoAntigo, novoVeiculo);
                System.out.println("Veículo editado com sucesso!");
            } else {
                System.out.println("Operação cancelada. Não foi fornecido um novo veículo.");
            }
        }

    }

    private static void removerVeiculo() {
        Veiculo veiculo = procurarVeiculo();
        remVeiculo(veiculo);
    }

    private static void cadastrarVeiculo() {
        Veiculo veiculo = menuCadastroVeiculo();
        try {
            Veiculo.addVeiculo(veiculo);
            System.out.println("O veiculo foi cadastrado com sucesso!");
        } catch (VeiculoExistenteException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static String pedirMarcaVeiculo() {
        System.out.println("Informe a marca do veículo:");
        return sc.next();
    }
    private static String pedirPlacaVeiculo() {
        System.out.println("Informe a placa: ");
        return sc.next();
    }
    private static String pedirModeloVeiculo() {
        System.out.println("Informe o modelo do veículo: ");
        return sc.next();
    }
    private static String pedirEstadoVeiculo() {
        System.out.println("Informe o estado do veículo(novo/usado): ");
        return sc.next();
    }
    private static Boolean pedirStatusVeiculo() {
        System.out.println("Informe o status do veículo(Disponivel/Vendido):");
        return sc.nextBoolean();
    }
    private static int pedirQuilometragemVeiculo() {
        System.out.println("Informe a quilometragem do veículo:");
        return sc.nextInt();
    }
    private static int pedirAnoVeiculo() {
        System.out.println("Informe o ano do veículo: ");
        return sc.nextInt();
    }
    private static float pedirPrecoVeiculo() {
        System.out.println("Digite o preço do veículo: ");
        return sc.nextFloat();
    }
    private static Veiculo menuCadastroVeiculo() {
        System.out.println("Digite o tipo de veículo que deseja cadastrar: ");
        System.out.println("""
                1- Carro
                2- Moto
                3- Caminhão
                """);
        int tipoVeiculo = sc.nextInt();

        String marca = pedirMarcaVeiculo();
        String placa = pedirPlacaVeiculo();
        String codigo = pedirCodigo();
        String estadoVeiculo = pedirEstadoVeiculo();
        boolean status = pedirStatusVeiculo();
        int quilometragem = pedirQuilometragemVeiculo();
        String modelo = pedirModeloVeiculo();
        int ano = pedirAnoVeiculo();
        float preco = pedirPrecoVeiculo();

        Veiculo veiculoGenerico = null;

        switch (tipoVeiculo) {
            case 1:
                veiculoGenerico = new Carro(marca, placa, codigo, estadoVeiculo, true, quilometragem, modelo, ano, preco);
                break;
            case 2:
                veiculoGenerico = new Moto(marca, placa, codigo, estadoVeiculo, true, quilometragem, modelo, ano, preco);
            case 3:
                System.out.println("Digite o peso máximo do veículo: ");
                float pesoMaximo = sc.nextFloat();

                System.out.println("Digite o comprimento do veículo: ");
                int comprimento = sc.nextInt();

                System.out.println("Digite a quantidade de rodas do veículo: ");
                int qntdRodas = sc.nextInt();
                veiculoGenerico = new Caminhao(marca, placa, codigo, estadoVeiculo, true, quilometragem, modelo, ano, preco, pesoMaximo, comprimento, qntdRodas);
        }
        return veiculoGenerico;
    }

    private static void editarUsuario() {

    }

    private static void verPagamento() throws VeiculoNaoEncontradoException {
        System.out.println("Pagamento: " + ((Funcionario) usuarioLogado).verPagamento());
    }

    private static void exibirCliente() {
        Usuario cliente = procurarCliente();
        System.out.println(cliente.toString());
    }

    private static Usuario procurarCliente() {
        String cpf = pedirCpf();
        Usuario cliente = Usuario.getUsuario(cpf);
        if (!(cliente instanceof Cliente)) {
            System.out.println("Cliente não consta na base de dados");
        }
        return cliente;
    }

    private static String pedirCpf() {
        System.out.println("Insira o CPF: ");
        return sc.next();
    }

    private static String pedirCodigo() {
        System.out.println("Digite o código do veículo: ");
        return sc.next();
    }

    private static String pedirNome() {
        System.out.println("Digite o nome: ");
        return sc.next();
    }

    private static String pedirSenha() {
        System.out.println("Digite a senha: ");
        return sc.next();
    }

    private static String pedirCnh() {
        System.out.println("Digite a cnh: ");
        return sc.next();
    }

    private static Veiculo procurarVeiculo() {
        String codigo = pedirCodigo();
        Veiculo veiculo = null;
        try {
            veiculo = getVeiculo(codigo);
        } catch (VeiculoNaoEncontradoException exception) {
            System.out.println(exception.getMessage());
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
        String cpf = pedirCpf();
        String senha = pedirSenha();
        try {
            usuarioLogado = Usuario.login(cpf, senha);
        } catch (UsuarioNaoEncontradoException exception) {
            System.out.println(exception.getMessage());
            System.out.println("""
                    Deseja realizar o cadastro?
                    1- Sim;
                    Outro - Não.
                    """);
            int escolha = sc.nextInt();
            if (escolha == 1) {
                cadastroUsuario();
            }
        } catch (SenhaIncorretaException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void cadastroUsuario() {
        String nome = pedirNome();
        String cpf = pedirCpf();
        String senha = pedirSenha();
        String cnh = pedirCnh();

        Usuario usuario = new Cliente(nome, cpf, senha, cnh);
        Usuario.addUsuario(usuario);
    }
}