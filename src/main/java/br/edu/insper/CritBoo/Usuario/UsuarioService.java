package br.edu.insper.CritBoo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios () {
        return usuarioRepository.findAll();
    }

    public void salvarUsuario(Usuario usuario){;
        usuarioRepository.save(usuario);
    }

    public Usuario getUsuario(int id) {
        return usuarioRepository.findById(id).get();
    }

    public void deleteUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario editarUsuario(Usuario usuarioAntes, Usuario usuario) {
        usuarioAntes.setEmail(usuario.getEmail());
        usuarioAntes.setNome(usuario.getNome());
        usuarioAntes.setDataNascimento(usuario.getDataNascimento());
        usuarioAntes.setSenha(usuario.getSenha());

        return usuarioRepository.save(usuarioAntes);
    }

}
