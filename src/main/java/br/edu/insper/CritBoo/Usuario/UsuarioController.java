package br.edu.insper.CritBoo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public HashMap<Integer, Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getNome() == null) {
            return "Nome não pode ser nulo";
        }

        if (usuario.getEmail() == null) {
            return "Email não pode ser nulo";
        }

        usuarioService.salvarUsuario(usuario);
        return "Usuario salvo com sucesso";
    }

    @GetMapping("/usuario/{id}")
    public Usuario getUsuario(@PathVariable int id) {
        return usuarioService.getUsuario(id);
    }

    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirUsuario(@PathVariable int id) {
        Usuario usuario = usuarioService.deleteUsuario(id);
        if (usuario != null) {
            return "Usuario removido com sucesso";
        }
        return "Usuario não encontrado";
    }

    @PutMapping("/usuario/{id}")
    public String editarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {

        Usuario usuarioretorno = usuarioService.editarUsuario(id, usuario);
        if (usuarioretorno != null) {
            return "Usuario alterado com sucesso";
        }
        return "Usuario não encontrado";
    }

}
