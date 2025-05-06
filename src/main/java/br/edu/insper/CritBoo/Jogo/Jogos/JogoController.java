package br.edu.insper.CritBoo.Jogo.Jogos;

import br.edu.insper.CritBoo.Jogo.Avaliacao.Avaliacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping()
    public Page<JogoDTO> getJogos(Pageable pageable) {
        return jogoService.getTodosJogos(pageable)
                .map(JogoDTO::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogo salvarJogo(@RequestBody Jogo jogo) {
        if (jogo.getNomeJogo() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser nulo");
        }

        if (jogo.getDescricaoJogo() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,  "Descrição não pode ser nulo");
        }

        if (jogo.getLancamentoJogo() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data de lançamento não pode ser nulo");
        }

        jogoService.salvarJogo(jogo);
        return jogo;
    }

    @GetMapping("/{id}")
    public JogoDTO getJogo(@PathVariable Integer id) {
        Jogo jogo = jogoService.getJogoPorId(id);
        if (jogo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo " + id + " não encontrado");
        }
        return new JogoDTO(jogo);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirJogo(@PathVariable Integer id) {
        Jogo jogo = jogoService.getJogos(id);
        if (jogo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo " + id + " não encontrado");
        }
        jogoService.deleteJogo(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarJogo(@PathVariable Integer id, @RequestBody Jogo jogo) {
        Jogo jogoEditado = jogoService.editarJogo(id, jogo);
        if (jogoEditado != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Jogo alterado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogo não encontrado");
    }

    @GetMapping("/recentes")
    public Page<Jogo> getJogosRecentes(@RequestParam(defaultValue = "5") int qtd, Pageable pageable) {
        return jogoService.getTopJogos(qtd);
    }

    @PostMapping("/{id}/comentarios")
    public ResponseEntity<String> adicionarComentario(@PathVariable Integer id, @RequestBody Avaliacao avaliacao) {
        Jogo jogo = jogoService.getJogos(id);
        if (jogo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo " + id + " não encontrado");
        }
        jogo.adicionarComentario(avaliacao);
        jogoService.salvarJogo(jogo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Comentário adicionado com sucesso");
    }

}
