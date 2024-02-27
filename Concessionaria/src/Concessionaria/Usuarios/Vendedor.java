package Concessionaria.Usuarios;

public class Vendedor extends Funcionario {

    public Vendedor(String nome, String cpf, float salario) {
        super(nome, cpf, salario);
    }

    public static void venderVeiculo(String codigoVeiculo, String cpf) {
        if (codigoVeiculo == codigoVeiculo) {
            System.out.println("Vendido");
        }
    }

    public static float verPagamento(float pagamento) {
        return pagamento;
    }
}
