package Concessionaria.Usuarios;

public class Cliente extends Usuario {

    private String cnh;

    public Cliente(String nome, String cpf, String senha, String cnh) {
        super(nome, cpf, senha);
        this.cnh = cnh;
    }

    public String getCnh() {
        return cnh;
    }

    public String toString() {
        return "Cliente{" +
                "cpf='" + getCpf() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", senha='" + getSenha() + '\'' +
                ", cnh= '" + cnh + '\'' +
                '}';
    }
}
