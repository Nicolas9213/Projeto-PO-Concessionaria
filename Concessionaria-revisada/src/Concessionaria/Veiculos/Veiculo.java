package Concessionaria.Veiculos;

import Concessionaria.Exceptions.VeiculoExistenteException;
import Concessionaria.Exceptions.VeiculoNaoEncontradoException;
import Concessionaria.Usuarios.Usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Veiculo {

    public static final ArrayList<Veiculo> veiculos = new ArrayList<>();

    private String marca;
    private String placa;
    private String codigo;
    private boolean novo;
    private boolean status;
    private int quilometragem;
    private String modelo;
    private int ano;
    private float preco;

    public Veiculo(String marca, String placa, String codigo, boolean novo, boolean status, int quilometragem,
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

    public static void addVeiculo(Veiculo veiculoGenerico) throws VeiculoExistenteException {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getCodigo() != veiculoGenerico.getCodigo()) {
                veiculos.add(veiculoGenerico);
            }
            throw new VeiculoExistenteException();
        }
    }

    public static Veiculo getVeiculo(String codigo) throws VeiculoNaoEncontradoException {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getCodigo().equals(codigo)) {
                return veiculo;
            }
        }
        throw new VeiculoNaoEncontradoException(codigo);
    }

    public static List<Veiculo> getVeiculos() {
        return Collections.unmodifiableList(veiculos);
    }

    public static void editarVeiculo(Veiculo novoVeiculo) {
        Veiculo.editarVeiculo(novoVeiculo);
    }

    public String getCodigo() {
        return codigo;
    }

    public float getPreco() {
        return preco;
    }

    public static void remVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public boolean isVendido() {
        return status;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String toString() {
        return "Veiculo:" +
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

    public String getInformacoesEstoque() {
        return this.codigo + ":" + this.marca + ":" + this.modelo + ":" + this.ano;
    }
}