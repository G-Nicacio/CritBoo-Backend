package br.edu.insper.CritBoo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@Service
public class UsuarioService {

    private HashMap<Integer, Usuario> usuarios = new HashMap<>();

    public HashMap<Integer, Usuario> getUsuarios () {
        return usuarios;
    }

    public void salvarUsuario(Usuario usuario){
        usuarios.put(usuario.getId(),usuario);
    }

    public Usuario getUsuario(int id) {
        return usuarios.get(id);
    }

    public Usuario deleteUsuario(int id) {
        return (usuarios.remove(id));
    }

    public Usuario editarUsuario(int id, Usuario usuario) {
        Usuario usuarioEditar = getUsuario(id);

        if (usuarioEditar != null) {

            if (usuario.getNome() != null) {
                usuarioEditar.setNome(usuario.getNome());
            }

            if (usuario.getDataNascimento() != usuarioEditar.getDataNascimento()) {
                usuarioEditar.setDataNascimento(usuario.getDataNascimento());
            }
        }
        return usuarioEditar;
    }

}
