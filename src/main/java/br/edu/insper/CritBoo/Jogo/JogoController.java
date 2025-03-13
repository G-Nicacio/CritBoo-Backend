package br.edu.insper.CritBoo.Jogo;

import br.edu.insper.CritBoo.Jogo.JogoService;
import br.edu.insper.CritBoo.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping("/jogos")
    public HashMap<Integer, Jogo> getjogo() {

        return jogoService.getJogos();
    }

    @PostMapping("/jogos")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarjogos(@RequestBody Jogo jogo) {
        if (jogo.getNomeJogo() == null) {
            return "Nome não pode ser nulo";
        }

        if (jogo.getDescricaoJogo() == null) {
            return "Descrição não pode ser nulo";
        }

        if (jogo.getLancamentoJogo() == null) {
            return "Data de lançamento não pode ser nulo";
        }

//        if (jogo.getEstudio() == null) {
//            return "Estudio não pode ser nulo";
//        }

        jogoService.salvarJogo(jogo);
        return "Jogo salvo com sucesso";
    }

    @GetMapping("/jogos/{id}")
    public Jogo getJogos(@PathVariable Integer id) {
        return jogoService.getJogos(id);
    }

    @DeleteMapping("/jogos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirJogo(@PathVariable Integer id) {
        Jogo jogo = jogoService.deleteJogo(id);
        if (jogo != null) {
            return "Jogo removido com sucesso";
        }
        return "Jogo não encontrado";
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
