package br.edu.insper.CritBoo.Jogo;

import br.edu.insper.CritBoo.Usuario.Usuario;
import br.edu.insper.CritBoo.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@RestController
public class AvaliacaoController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JogoService jogoService;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/avaliacao")
    public List<Avaliacao> getAvaliacao() {
        if (avaliacaoService.getAvaliacoes().size() > 0){
            return avaliacaoService.getAvaliacoes();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há avaliações registradas");
    }

    @GetMapping("/avaliacao/{id}")
    public Avaliacao getAvaliacao(@PathVariable Integer id) {
        if (avaliacaoService.getUmaAvaliacao(id) != null){
            return avaliacaoService.getUmaAvaliacao(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação " + id + " não encontrada");
    }

    @PostMapping("/avaliacao")
    public Avaliacao registrarAvaliasao(@RequestBody Avaliacao avaliacao){
        Usuario usuario = usuarioService.getUsuario(avaliacao.getUsuario().getId());
        if (usuario == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O usuário " + avaliacao.getUsuario().getId() + " não foi encontrado");
        }
        Jogo jogo = jogoService.getJogos(avaliacao.getJogo().getId());
        if (jogo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O jogo " + avaliacao.getJogo().getId() + " não foi encontrado");
        }
        if (avaliacao.getComentario() ==  null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Precisa deixar um comentário");
        }
        if (avaliacao.getNota() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Precisa deixar uma nota");
        }

        avaliacaoService.registrarAvaliacao(avaliacao);

        return avaliacao;
    }

    @DeleteMapping("/avaliacao/{id}")
    public Avaliacao deletarAvaliacao(@PathVariable Integer id) {
        Avaliacao avaliacaoDeletada = avaliacaoService.getUmaAvaliacao(id);
        if (avaliacaoDeletada != null){
            avaliacaoService.deletarAvaliacao(id);
            return avaliacaoDeletada;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação " + id + " não encontrada");
    }

    @PutMapping("/avaliacao/{id}")
    public Avaliacao atualizarAvaliacao(@PathVariable Integer id, @RequestBody Avaliacao avaliacao){
        Usuario usuario = usuarioService.getUsuario(avaliacao.getUsuario().getId());
        if (usuario == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O usuário " + avaliacao.getUsuario().getId() + " não foi encontrado");
        }
        Jogo jogo = jogoService.getJogos(avaliacao.getJogo().getId());
        if (jogo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O jogo " + avaliacao.getJogo().getId() + " não foi encontrado");
        }
        if (avaliacao.getComentario() ==  null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Precisa deixar um comentário");
        }
        if (avaliacao.getNota() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Precisa deixar uma nota");
        }

        Avaliacao avaliacaoAnterior = avaliacaoService.getUmaAvaliacao(id);
        if (avaliacaoAnterior == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação não encontrada");
        }

        return avaliacaoService.editarAvaliacao(avaliacaoAnterior, avaliacao);
    }
}
