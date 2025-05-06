package br.edu.insper.CritBoo.Jogo.Avaliacao;

import br.edu.insper.CritBoo.Jogo.Jogos.Jogo;
import br.edu.insper.CritBoo.Jogo.Jogos.JogoService;
import br.edu.insper.CritBoo.Usuario.Usuarios.Usuario;
import br.edu.insper.CritBoo.Usuario.Usuarios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JogoService jogoService;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/jogo/{jogoId}")
    public List<Avaliacao> getAvaliacoesPorJogo(@PathVariable Integer jogoId) {
        Jogo jogo = jogoService.getJogos(jogoId);
        if (jogo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo " + jogoId + " não encontrado");
        }
        List<Avaliacao> avaliacoes = avaliacaoService.getAvaliacoesPorJogo(jogo);
        if (avaliacoes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há avaliações para o jogo " + jogoId);
        }
        return avaliacoes;
    }

    @PostMapping("/")
    public Avaliacao registrarAvaliacoes(@RequestBody Avaliacao avaliacao) {
        if (avaliacao == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A avaliação não pode ser nula");
        }


        Usuario usuario = usuarioService.getUsuario(avaliacao.getUsuario().getId());
        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }

        Jogo jogo = jogoService.getJogos(avaliacao.getJogo().getId());
        if (jogo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado");
        }

        if (avaliacao.getComentario() == null || avaliacao.getComentario().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comentário não pode ser vazio");
        }
        if (avaliacao.getNota() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nota é obrigatória");
        }

        System.out.println("Avaliação recebida: " + avaliacao.getJogo().getId());
        avaliacao.setUsuario(avaliacao.getUsuario());
        avaliacao.setJogo(avaliacao.getJogo());

        avaliacaoService.registrarAvaliacao(avaliacao);

        return avaliacao;
    }

    @DeleteMapping("/{id}")
    public Avaliacao deletarAvaliacao(@PathVariable Integer id) {
        Avaliacao avaliacaoDeletada = avaliacaoService.getUmaAvaliacao(id);
        if (avaliacaoDeletada != null) {
            avaliacaoService.deletarAvaliacao(id);
            return avaliacaoDeletada;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação não encontrada");
    }

    @PutMapping("/{id}")
    public Avaliacao atualizarAvaliacao(@PathVariable Integer id, @RequestBody Avaliacao avaliacao) {
        Usuario usuario = usuarioService.getUsuario(avaliacao.getUsuario().getId());
        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        Jogo jogo = jogoService.getJogos(avaliacao.getJogo().getId());
        if (jogo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado");
        }
        if (avaliacao.getComentario() == null || avaliacao.getComentario().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comentário não pode ser vazio");
        }
        if (avaliacao.getNota() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nota é obrigatória");
        }

        Avaliacao avaliacaoAnterior = avaliacaoService.getUmaAvaliacao(id);
        if (avaliacaoAnterior == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação não encontrada");
        }

        return avaliacaoService.editarAvaliacao(avaliacaoAnterior, avaliacao);
    }
}
