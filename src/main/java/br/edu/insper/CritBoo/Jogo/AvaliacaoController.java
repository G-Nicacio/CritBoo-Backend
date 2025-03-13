package br.edu.insper.CritBoo.Jogo;

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

//    @GetMapping("/jogo/{id}/avaliacao")
//    public HashMap<String, Usuario> getavaliacao() {
//        return avaliacaoService.getAvaliacao();
//    }

}
