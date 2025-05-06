package br.edu.insper.CritBoo.Jogo.Estudio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/estudio")
public class EstudioController {

    @Autowired
    private EstudioService estudioService;

    @GetMapping
    public List<Estudio> getEstudios() {
        List<Estudio> estudios = estudioService.getEstudios();
        if (estudios.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum estúdio encontrado.");
        }
        return estudios;
    }

    @GetMapping("/{id}")
    public Estudio getEstudio(@PathVariable Integer id) {
        return estudioService.getEstudio(id);
    }

    @PostMapping
    public Estudio criarEstudio(@RequestBody Estudio estudio) {
        if (estudio.getNomeEstudio() == null || estudio.getDataFundacao() == null || estudio.getImagem() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos obrigatórios ausentes.");
        }
        estudioService.criarEstudio(estudio);
        return estudio;
    }

    @PutMapping("/{id}")
    public Estudio atualizarEstudio(@PathVariable Integer id, @RequestBody Estudio estudio) {
        return estudioService.atualizarEstudio(id, estudio);
    }

    @DeleteMapping("/{id}")
    public void deletarEstudio(@PathVariable Integer id) {
        estudioService.deletarEstudio(id);
    }
}
