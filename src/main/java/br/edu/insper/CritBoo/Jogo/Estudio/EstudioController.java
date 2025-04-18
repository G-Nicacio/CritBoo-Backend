package br.edu.insper.CritBoo.Jogo.Estudio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class EstudioController {
    @Autowired
    private EstudioService estudioService;

    @GetMapping("/estudio")
    public List<Estudio> getEstudios() {
        return estudioService.getEstudios();
    }

    @GetMapping("/estudio/{nomeEstudio}")
    public Estudio getEstudioEspecifico(@PathVariable Integer id) {
        return estudioService.getEstudioEspecifico(id);
    }

    @PostMapping("/estudio")
    public Estudio registrarEstudio(@RequestBody Estudio estudio) {
        if (estudio.getNomeEstudio() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser nulo");
        }

        if (estudio.getDataFundacao() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data de fundação não pode ser nula");
        }

        estudioService.registrarEstudio(estudio);
        return estudio;
    }

    @DeleteMapping("/estudio/{nomeEstudio}")
    public Estudio deletarEstudio(@PathVariable Integer id) {
        Estudio estudio = estudioService.getEstudioEspecifico(id);
        if (estudio == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudio " + id + " não encontrado");
        }

        estudioService.removerEstudio(id);
        return estudio;
    }

    @PutMapping("/estudio/{nomeEstudio}")
    public Estudio atualizarEstudio(@PathVariable Integer id, @RequestBody Estudio estudio) {
        Estudio estudioAntigo = estudioService.getEstudioEspecifico(id);
        if (estudioAntigo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudio " + id + " não encontrado");
        }

        if (estudio.getNomeEstudio() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser nulo");
        }

        if (estudio.getDataFundacao() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data de fundação não pode ser nula");
        }

        estudioService.atualizarEstudio(estudioAntigo, estudio);
        return estudio;
    }
}
