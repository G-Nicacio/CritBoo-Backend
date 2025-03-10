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
    public HashMap<String, Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getNome() == null) {
            return "Nome não pode ser nulo";
        }

        if (usuario.getEmail() == null) {
            return "CPF não pode ser nulo";
        }

        usuarioService.salvarUsuario(usuario);
        return "Usuario salvo com sucesso";
    }

    @GetMapping("/usuario/{email}")
    public Usuario getUsuario(@PathVariable String email) {
        return usuarioService.getUsuario(email);
    }

    @DeleteMapping("/usuario/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirUsuario(@PathVariable String email) {
        Usuario usuario = usuarioService.deleteUsuario(email);
        if (usuario != null) {
            return "Usuario removido com sucesso";
        }
        return "Usuario não encontrado";
    }

    @PutMapping("/usuario/{email}")
    public String editarUsuario(@PathVariable String email, @RequestBody Usuario usuario) {

        Usuario usuarioretorno = usuarioService.editarUsuario(email, usuario);
        if (usuarioretorno != null) {
            return "Usuario alterado com sucesso";
        }
        return "Usuario não encontrado";
    }

}
