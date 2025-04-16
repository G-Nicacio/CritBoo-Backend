package br.edu.insper.CritBoo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getNome() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser nulo");
        }

        if (usuario.getEmail() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "e-mail não pode ser nulo");
        }

        if (usuario.getDataNascimento() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data de nascimento não pode ser nula");
        }

        if (usuario.getSenha() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha não pode ser nula");
        }

        usuarioService.salvarUsuario(usuario);
        return usuario;
    }

    @GetMapping("/usuario/{id}")
    public Usuario getUsuario(@PathVariable int id) {
        return usuarioService.getUsuario(id);
    }

    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Usuario excluirUsuario(@PathVariable int id) {
        Usuario usuario = usuarioService.getUsuario(id);
        if (usuario == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário " + id + " não encontrado");
        }
        usuarioService.deleteUsuario(id);
        return usuario;
    }

    @PutMapping("/usuario/{id}")
    public Usuario editarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {

        if (usuario.getNome() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser nulo");
        }

        if (usuario.getEmail() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "e-mail não pode ser nulo");
        }

        if (usuario.getDataNascimento() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data de nascimento não pode ser nula");
        }

        if (usuario.getSenha() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha não pode ser nula");
        }

        Usuario usuarioAntes = usuarioService.getUsuario(id);
        if (usuarioAntes == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário " + id + " não encontrado");
        }

        usuarioService.editarUsuario(usuarioAntes, usuario);
        return usuario;
    }

}
