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

    public static List<Veiculo> getVeiculos() {

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

    public static List<Veiculo> verVeiculos() { // Método poderia ser getVeiculos()
        return Collections.unmodifiableList(veiculos);
    }

}