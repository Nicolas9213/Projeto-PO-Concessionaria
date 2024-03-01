package Concessionaria;

public class Venda {

    private String cpfVendedor;
    private String cpfCliente;
    private String codigo;

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
