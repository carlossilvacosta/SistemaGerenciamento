package services;

import java.util.ArrayList;
import java.util.List;

import entities.Usuario;
import util.GerenciamentoDados;

public class CadastroUsuario implements GerenciamentoDados {

    private List<Usuario> usuarios;

    public CadastroUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public List<Usuario> getUsuarios() {
        if(usuarios == null) {
            usuarios = new ArrayList<>();
        }
        return usuarios;
    }

    @Override
    public void adicionar(Object obj) {
         if (obj instanceof Usuario) {
            usuarios.add((Usuario) obj);
        }
    }

    @Override
    public void remover(long id) {
        usuarios.removeIf(usuario -> usuario.getId() == id);
    }

    @Override
    public Object buscarPorId(long id) {
        for(Usuario usuario : usuarios) {
            if(usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<Object> listarTodos() {
        return new ArrayList<>(usuarios);
    }
    
}
