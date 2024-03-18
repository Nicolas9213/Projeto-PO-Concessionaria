package Concessionaria.Usuarios;

import Concessionaria.Exceptions.VeiculoNaoEncontradoException;
import Concessionaria.Veiculos.Veiculo;
import Concessionaria.Venda;

public class Vendedor extends Funcionario {

    public Vendedor(String nome, String cpf, String senha,  float salario) {
        super(nome, cpf, senha, salario);
    }

    @Override
    public void venderVeiculo(String codigoVeiculo, String cpfCliente) {

    }

    @Override
    public float verPagamento() throws VeiculoNaoEncontradoException {
        float comissao = 0;

        for (Venda venda : vendas) {
            Veiculo veiculo = Veiculo.getVeiculo(venda.getCodigo());

            if (veiculo != null) {
                comissao += veiculo.getPreco() * 0.01;
            }
        }
        return (comissao + this.salario);
    }

    public String toString() {
        return "Funcionario{" +
                "cpf='" + getCpf() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", senha='" + getSenha() + '\'' +
                ", salario= '" + salario + '\'' +
                '}';
    }
}
