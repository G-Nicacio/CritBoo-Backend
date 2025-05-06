package br.edu.insper.CritBoo.Usuario.JogosFavoritos;

import br.edu.insper.CritBoo.Jogo.Jogos.Jogo;
import br.edu.insper.CritBoo.Usuario.Usuarios.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/jogos-favoritos")
public class JogosFavoritosController {

    @Autowired
    private JogosFavoritosService jogosFavoritosService;

    @PostMapping("/adicionar")
    public JogosFavoritos adicionarJogoFavorito(@RequestParam Integer usuarioId, @RequestParam Integer jogoId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        Jogo jogo = new Jogo();
        jogo.setId(jogoId);
        return jogosFavoritosService.adicionarJogoFavorito(usuario, jogo);
    }

    @GetMapping("/favoritos/{usuarioId}")
    public Set<Jogo> obterJogosFavoritos(@PathVariable Integer usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return jogosFavoritosService.obterJogosFavoritos(usuario);
    }
}
