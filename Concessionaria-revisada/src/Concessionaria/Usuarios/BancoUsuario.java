package Concessionaria.Usuarios;

import Concessionaria.Exceptions.UsuarioNaoEncontradoException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class BancoUsuario {
    private List<Usuario> listaUsuarios;

    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(listaUsuarios);
    }

    public void remover(String cpf) throws UsuarioNaoEncontradoException {
        Usuario usuario = procurarUsuario(cpf);
        listaUsuarios.remove(usuario);
    }

    public void adicionar(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public void alterar(String cpf, Usuario novoUsuario) throws UsuarioNaoEncontradoException {
        Usuario usuario = procurarUsuario(cpf);
        listaUsuarios.set(listaUsuarios.indexOf(usuario), novoUsuario);
    }

    Usuario procurarUsuario(String cpf) throws UsuarioNaoEncontradoException {
        for (Usuario usuarioProcurado : listaUsuarios) {
            if (usuarioProcurado.getCpf().equals(cpf)) {
                return usuarioProcurado;
            }
        }
        throw new UsuarioNaoEncontradoException();
    }
}
