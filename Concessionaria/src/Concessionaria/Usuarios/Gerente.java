package Concessionaria.Usuarios;

import Concessionaria.Veiculos.Veiculo;

public class Gerente extends Funcionario {

    public Gerente(String nome, String cpf, float salario) {
        super(nome, cpf, salario);
    }

    public static void venderVeiculo(String codigoVeiculo, String cpf) {

    }

    public static void remVeiculo(String codigo) {
        Veiculo.remVeiculo(codigo);
    }

    public static void cadastrarVeiculo(Veiculo veiculo) {
        Veiculo.addVeiculo(veiculo);
    }

    public static void alterarPreco(String codigo, float novoPreco) {
        Veiculo veiculo = null;
        veiculo.setPreco(novoPreco);
    }

    public static void editarVeiculo(String codigo, Veiculo novoVeiculo) {

    }

    public static void editarUsuario(String cpf, Usuario usuario) {

    }

    public static float verPagamentos() {
        return 2;
    }

    public static float verPagamentoUmVendedor(String cpf) {
        return 2;
    }

    public static void cadastrarUsuario(Usuario usuario) {
        if (!(usuario instanceof Gerente)) {
            Usuario.addUsuario(usuario);
        }
    }

    public static void removerUsuario(Usuario usuario, String cpf) {
        if (!(usuario instanceof Gerente)) {
            Usuario.addUsuario(usuario);
        }
    }

    public String verMeusVeiculos() {
        return Veiculo.verVeiculos().toString();
    }
}
