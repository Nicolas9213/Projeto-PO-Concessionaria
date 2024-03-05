package Concessionaria.Veiculos;

public class Caminhao extends Veiculo {

    private String pesoMaximo;
    private int comprimento;
    private int qntdRodas;

    public String toString() {
        return "Caminhao{" +
                "pesoMaximo='" + pesoMaximo + '\'' +
                ", comprimento='" + comprimento + '\'' +
                ", qntdRodas='" + qntdRodas + '\'' +
                '}';
    }

    public Caminhao(String marca, String placa, String codigo, boolean novo, String status, int quilometragem, String modelo, int ano, float preco) {
        super(marca, placa, codigo, novo, status, quilometragem, modelo, ano, preco);
    }
}
