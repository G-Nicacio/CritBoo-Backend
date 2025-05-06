package br.edu.insper.CritBoo.Jogo.Jogos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public Page<Jogo> getJogos(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) LocalDate lancamentoJogo,
            Pageable pageable) {
        return jogoService.getJogos(nome, lancamentoJogo, pageable);
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
    public Jogo getJogo(@PathVariable Integer id) {
        Jogo jogo = jogoService.getJogos(id);
        if (jogo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo " + id + " não encontrado");
        }
        return jogo;
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
}
