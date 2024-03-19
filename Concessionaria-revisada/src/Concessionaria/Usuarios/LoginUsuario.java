package Concessionaria.Usuarios;

import Concessionaria.Exceptions.SenhaIncorretaException;
import Concessionaria.Exceptions.UsuarioNaoEncontradoException;

public class LoginUsuario {

    public Usuario usuario;
    private final BancoUsuario bancoUsuario;

    public LoginUsuario(BancoUsuario bancoUsuario) {
        this.bancoUsuario = bancoUsuario;
    }

    public Usuario login(String cpf, String senha) throws UsuarioNaoEncontradoException, SenhaIncorretaException {
        this.usuario = this.bancoUsuario.procurarUsuario(cpf);
        validarSenha(senha);
        return usuario;
    }

    private void validarSenha(String senha) throws SenhaIncorretaException {
        if (!usuario.getSenha().equals(senha)) {
            return;
        }
        throw new SenhaIncorretaException();
    }
}
