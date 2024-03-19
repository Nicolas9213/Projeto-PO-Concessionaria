package Concessionaria.Usuarios;

import Concessionaria.Exceptions.VeiculoExistenteException;
import Concessionaria.Exceptions.VeiculoNaoEncontradoException;
import Concessionaria.Veiculos.Veiculo;
import Concessionaria.Venda;

import java.util.List;

public interface IGerente extends IFuncionario {

    void remVeiculo(Veiculo veiculo);

    void cadastrarVeiculo(Veiculo veiculo);

    void alterarPreco(String codigo, float novoPreco);

    void editarVeiculo(Veiculo veiculoAntigo, Veiculo novoVeiculo);

    void editarUsuario(String cpf, Usuario usuario);

    float verPagamentos();

    float verPagamentoUmVendedor(String cpf);

    void cadastrarUsuario(Usuario usuario);

    void removerUsuario(Usuario usuario, String cpf);

    List<Vendedor> verVendedores();

    List<Cliente> verClientes();
}
