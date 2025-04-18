package br.edu.insper.CritBoo.Jogo.Jogos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping("/jogos")
    public List<Jogo> getjogo() {
        if (jogoService.getJogos().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há jogos registrados");
        }
        return jogoService.getJogos();
    }

    @PostMapping("/jogos")
    @ResponseStatus(HttpStatus.CREATED)
    public Jogo salvarjogos(@RequestBody Jogo jogo) {
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

    @GetMapping("/jogos/{id}")
    public Jogo getJogos(@PathVariable Integer id) {
        Jogo jogo = jogoService.getJogos(id);
        if (jogo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo " + id + " não encontrado");
        }
        return jogo;
    }

    @DeleteMapping("/jogos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Jogo excluirJogo(@PathVariable Integer id) {
        Jogo jogo = jogoService.getJogos(id);
        if (jogo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo " + id + " não encontrado");
        }
        jogoService.deleteJogo(id);
        return jogo;
    }

    @PutMapping("/jogos/{id}")
    public String editarUsuario(@PathVariable Integer id, @RequestBody Jogo jogo) {

        Jogo jogoretorno = jogoService.editarJogo(id, jogo);
        if (jogoretorno != null) {
            return "Jogo alterado com sucesso";
        }
        return "Jogo não encontrado";
    }
}
