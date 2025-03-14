package br.edu.insper.CritBoo.Jogo;
import org.springframework.web.bind.annotation.*;
import br.edu.insper.CritBoo.Usuario.Usuario;
import br.edu.insper.CritBoo.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/avaliacao")
    public HashMap<Integer, Avaliacao> getAvaliacaos() {
        return avaliacaoService.getAvaliacoes();
    }

    @GetMapping("/avaliacao/{id}")
    public Avaliacao getAvaliacao(@PathVariable Integer id) {
        return avaliacaoService.getUmaAvaliacao(id);
    }

    @PostMapping("/avaliacao")
    public String registrarAvaliasao(@RequestBody Avaliacao avaliacao){
        Avaliacao avaliacaoRegistrada = avaliacaoService.registrarAvaliacao(avaliacao);
        if (avaliacaoRegistrada != null){
            return "Avaliação registrada";
        }
        return "Está faltando alguma informação";
    }

    @DeleteMapping("/avaliacao/{id}")
    public String deletarAvaliacao(@PathVariable Integer id) {
        Avaliacao avaliacaoDeletada = avaliacaoService.deletarAvaliacao(id);
        if (avaliacaoDeletada != null){
            return "Avaliação deletada";
        }
        return "Avaliação não encontrada";
    }

    @PutMapping("/acaliacao/{id}")
    public String editarAvaliacao(@PathVariable Integer id, @RequestBody Avaliacao avaliacao) {

        Avaliacao avaliacaoretorno = avaliacaoService.editarAvaliacao(id, avaliacao);
        if (avaliacaoretorno != null) {
            return "Jogo alterado com sucesso";
        }
        return "Jogo não encontrado";
    }

}
