package Concessionaria.Usuarios;

import Concessionaria.Veiculos.Veiculo;
import Concessionaria.Venda;

import java.util.ArrayList;

public abstract class Funcionario extends Usuario {

    private ArrayList<Venda> vendas = new ArrayList<Venda>();

    private float salario;


    public Funcionario(String nome, String cpf, String senha, float salario) {
        super(nome, cpf, senha);
        this.salario = salario;
    }

    public static void venderVeiculo(String codigoVeiculo, String cpfCliente) {
    }

    public static Cliente procurarCliente(String cpf) {
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

    public int verPagamento(int pagamento) {
        return pagamento;
    }

    public String verMeusVeiculos() {
        return Veiculo.verVeiculos().toString();
    }
}
