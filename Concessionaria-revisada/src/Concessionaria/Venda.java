package Concessionaria;

import Concessionaria.Usuarios.Usuario;
import Concessionaria.Veiculos.Veiculo;

public class Venda {

    private String cpfVendedor;
    private String cpfCliente;
    private String codigo;

    public Venda(String cpf, Usuario cliente, Veiculo veiculo) {
    }

    public String getCpfVendedor() {
        return cpfVendedor;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public Venda(String codigo, String cpfCliente, String cpfVendedor) {
        this.codigo = codigo;
        this.cpfCliente = cpfCliente;
        this.cpfVendedor = cpfVendedor;
    }
}
