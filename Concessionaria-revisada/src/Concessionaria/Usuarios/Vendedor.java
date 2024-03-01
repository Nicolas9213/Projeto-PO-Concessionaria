package Concessionaria.Usuarios;

public class Vendedor extends Funcionario {

    public Vendedor(String nome, String cpf, String senha,  float salario) {
        super(nome, cpf, senha, salario);
    }

    @Override
    public void venderVeiculo(String codigoVeiculo, String cpfCliente) {

    }

    @Override
    public void verPagamento(int pagamento) {

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
