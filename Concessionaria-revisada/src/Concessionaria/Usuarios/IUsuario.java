package Concessionaria.Usuarios;

import Concessionaria.Veiculos.Veiculo;

import java.util.List;

public interface IUsuario {

    List<Veiculo> verVeiculos();

    List<Veiculo> verMeusVeiculos();

    Veiculo verVeiculo(String codigo);

}
