package br.edu.insper.CritBoo.Usuario.Historico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/historico/{id}")
public class HistoricoController {
    @Autowired
    private HistoricoService historicoService;

    @GetMapping
    public Historico getHistorico(@PathVariable Integer id){
        return historicoService.getHistorico(id);
    }


}
