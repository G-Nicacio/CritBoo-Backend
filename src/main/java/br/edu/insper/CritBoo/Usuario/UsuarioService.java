package br.edu.insper.CritBoo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@Service
public class UsuarioService {

    private HashMap<String, Usuario> usuarios = new HashMap<>();

    public HashMap<String, Usuario> getUsuarios () {
        return usuarios;
    }

    public void salvarUsuario(Usuario usuario){
        usuarios.put(usuario.getEmail(),usuario);
    }

    public Usuario getUsuario(String email) {
        return usuarios.get(email);
    }

    public Usuario deleteUsuario(String email) {
        return (usuarios.remove(email));
    }

    public Usuario editarUsuario(String email, Usuario usuario) {
        Usuario usuarioEditar = getUsuario(email);

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
