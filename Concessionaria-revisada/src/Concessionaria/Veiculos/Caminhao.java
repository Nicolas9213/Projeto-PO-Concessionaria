package Concessionaria.Veiculos;

public class Caminhao extends Veiculo {

    private float pesoMaximo;
    private int comprimento;
    private int qntdRodas;

    public Caminhao(String marca, String placa, String codigo, boolean novo, boolean status, int quilometragem, String modelo, int ano, float preco, float pesoMaximo, int comprimento, int qntdRodas) {
        super(marca, placa, codigo, novo, status, quilometragem, modelo, ano, preco);
        this.pesoMaximo = pesoMaximo;
        this.comprimento = comprimento;
        this.qntdRodas = qntdRodas;
    }

    public String toString() {
        return "Caminhao{" +
                "pesoMaximo='" + pesoMaximo + '\'' +
                ", comprimento='" + comprimento + '\'' +
                ", qntdRodas='" + qntdRodas + '\'' +
                '}';
    }

}
