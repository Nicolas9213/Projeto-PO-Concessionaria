package Concessionaria.Usuarios;

import Concessionaria.Exceptions.VeiculoNaoEncontradoException;
import Concessionaria.Veiculos.Veiculo;
import Concessionaria.Venda;

import java.util.ArrayList;

public abstract class Funcionario extends Usuario {

    protected static final ArrayList<Venda> vendas = new ArrayList<Venda>();

    protected float salario;


    public Funcionario(String nome, String cpf, String senha, float salario) {
        super(nome, cpf, senha);
        this.salario = salario;
    }

    protected abstract void venderVeiculo(String codigoVeiculo, String cpfCliente);

    protected static Cliente procurarCliente(String cpf) {
        for (Usuario cliente : usuarios) {
            if (cliente instanceof Cliente && cliente.getCpf().equals(cpf)) {
                return (Cliente) cliente;
            }
        }
        return null;
    }

    public static void addVenda(Venda venda) {
        vendas.add(venda);
    }

    public abstract float verPagamento() throws VeiculoNaoEncontradoException;

    public String toString() {
        return "Funcionario{" +
                "cpf='" + getCpf() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", senha='" + getSenha() + '\'' +
                ", salario= '" + salario + '\'' +
                '}';
    }
}
