package Concessionaria.Usuarios;

import Concessionaria.Veiculos.Veiculo;

import java.util.List;

public class Gerente extends Funcionario {

    public Gerente(String nome, String cpf,String senha, float salario) {
        super(nome, cpf, senha,salario);
    }

    public void venderVeiculo(String codigoVeiculo, String cpf) {

    }

    @Override
    protected void verPagamento(int pagamento) {

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
    /**
    public List<Veiculo> verMeusVeiculos() {
        return Veiculo.getVeiculos().toString();
    }**/
}
