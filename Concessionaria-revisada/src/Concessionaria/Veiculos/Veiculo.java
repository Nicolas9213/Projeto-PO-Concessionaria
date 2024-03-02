package Concessionaria.Veiculos;

import Concessionaria.Usuarios.Usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Veiculo {

    private static final ArrayList<Veiculo> veiculos = new ArrayList<>();

    private String marca;
    private String placa;
    private String codigo;
    private boolean novo;
    private String status;
    private int quilometragem;
    private String modelo;
    private int ano;
    private float preco;

    public Veiculo(String marca, String placa, String codigo, boolean novo, String status, int quilometragem,
                   String modelo, int ano, float preco) {
        this.marca = marca;
        this.placa = placa;
        this.codigo = codigo;
        this.novo = novo;
        this.status = status;
        this.quilometragem = quilometragem;
        this.modelo = modelo;
        this.ano = ano;
    }

    public static Veiculo verVeiculo(String codigo) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.codigo == codigo) {
                return veiculo;
            }
        }
        return null;
    }

    public static void addVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public static Veiculo getVeiculo(String codigo) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getCodigo().equals(codigo)) {
                return veiculo;
            }
        }
        return null;
    }

    public String getCodigo() {
        return codigo;
    }

    public float getPreco() {
        return preco;
    }

    public static void remVeiculo(String codigo) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.codigo == codigo) {
                veiculos.remove(veiculo);
                return;
            }
        }
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static List<Veiculo> getVeiculos() {
        return Collections.unmodifiableList(veiculos);
    }

    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", placa='" + placa + '\'' +
                ", codigo='" + codigo + '\'' +
                ", novo='" + novo + '\'' +
                ", status='" + status + '\'' +
                ", quilometragem='" + quilometragem + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano='" + ano + '\'' +
                '}';
    }
}