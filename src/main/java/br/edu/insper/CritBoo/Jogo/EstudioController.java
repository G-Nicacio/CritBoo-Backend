package br.edu.insper.CritBoo.Jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class EstudioController {
    @Autowired
    private EstudioService estudioService;

    @GetMapping("/estudio")
    public HashMap<String, Estudio> getEstudios() {
        return estudioService.getEstudios();
    }

    @GetMapping("/estudio/{nomeEstudio}")
    public Estudio getEstudioEspecifico(@PathVariable String nomeEstudio) {
        return estudioService.getEstudioEspecifico(nomeEstudio);
    }

    @PostMapping("/estudio")
    public Estudio registrarEstudio(@RequestBody Estudio estudio) {
        return estudioService.registrarEstudio(estudio);
    }

    @DeleteMapping("/estudio/{nomeEstudio}")
    public Estudio deletarEstudio(@PathVariable String nomeEstudio) {
        return estudioService.removerEstudio(nomeEstudio);
    }

    @PutMapping("/estudio/{nomeEstudio}")
    public HashMap<String, Estudio> atualizarEstudio(@PathVariable String nomeEstudio, @RequestBody Estudio estudio) {
        return estudioService.atualizarEstudio(nomeEstudio, estudio);
    }
}
