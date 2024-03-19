package Concessionaria.Usuarios;

import Concessionaria.Veiculos.Veiculo;

public interface IFuncionario {

    void vender(Veiculo veiculo, Usuario cliente);

    Usuario buscarUsuario(String cpf);

    String verPagamento();
}
