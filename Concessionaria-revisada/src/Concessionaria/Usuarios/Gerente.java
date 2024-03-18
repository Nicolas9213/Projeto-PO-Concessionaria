package Concessionaria.Usuarios;

import Concessionaria.Exceptions.VeiculoExistenteException;
import Concessionaria.Exceptions.VeiculoNaoEncontradoException;
import Concessionaria.Veiculos.Veiculo;
import Concessionaria.Venda;

import java.util.List;

public class Gerente extends Funcionario {

    public Gerente(String nome, String cpf,String senha, float salario) {
        super(nome, cpf, senha,salario);
    }

    public void venderVeiculo(String codigoVeiculo, String cpf) {

    }

    @Override
    public float verPagamento() throws VeiculoNaoEncontradoException {
        float comissao = 0;

        for (Venda venda : vendas) {
            Veiculo veiculo = Veiculo.getVeiculo(venda.getCodigo());

            if (veiculo != null) {
                comissao += veiculo.getPreco() * 0.02;
            }
        }
        return (comissao + this.salario);
    }

    public static void remVeiculo(Veiculo veiculo) {
        remVeiculo(veiculo);
    }

    public static void cadastrarVeiculo(Veiculo veiculo) throws VeiculoExistenteException {
        Veiculo.addVeiculo(veiculo);
    }

    public static void alterarPreco(String codigo, float novoPreco) {
        Veiculo veiculo = null;
        veiculo.setPreco(novoPreco);
    }

    public static void editarVeiculo(Veiculo veiculoAntigo, Veiculo novoVeiculo) {
        Veiculo.editarVeiculo(novoVeiculo);
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
