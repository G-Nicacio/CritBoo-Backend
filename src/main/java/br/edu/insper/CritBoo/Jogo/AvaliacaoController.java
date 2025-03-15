package br.edu.insper.CritBoo.Jogo;

import br.edu.insper.CritBoo.Usuario.Usuario;
import br.edu.insper.CritBoo.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/avaliacao")
    public HashMap<Integer, Avaliacao> getAvaliacao() {
        return avaliacaoService.getAvaliacoes();
    }

    @GetMapping("/avaliacao/{id}")
    public Avaliacao getAvaliacao(@PathVariable Integer id) {
        return avaliacaoService.getUmaAvaliacao(id);
    }

    @PostMapping("/avaliacao")
    public String registrarAvaliasao(@RequestBody Avaliacao avaliacao){
        return avaliacaoService.registrarAvaliacao(avaliacao);
    }

    @DeleteMapping("/avaliacao/{id}")
    public String deletarAvaliacao(@PathVariable Integer id) {
        Avaliacao avaliacaoDeletada = avaliacaoService.deletarAvaliacao(id);
        if (avaliacaoDeletada != null){
            return "Avaliação deletada";
        }
        return "Avaliação não encontrada";
    }

    @PutMapping("/avaliacao/{id}")
    public String atualizarAvaliacao(@PathVariable Integer id, @RequestBody Avaliacao avaliacao){
        return avaliacaoService.editarAvaliacao(id, avaliacao);
//        Avaliacao avaliacaoEditada = avaliacaoService.editarAvaliacao(id, avaliacao);
//        if (avaliacaoEditada != null) {
//            return "Avaliação editada";
//        }
//        return "Avaliação não encontrada";
    }
}
