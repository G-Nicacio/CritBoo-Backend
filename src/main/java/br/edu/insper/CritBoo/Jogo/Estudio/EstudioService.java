package br.edu.insper.CritBoo.Jogo.Estudio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

    public List<Estudio> getEstudios() {
        return estudioRepository.findAll();
    }

    public Estudio getEstudio(Integer id) {
        return estudioRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Estúdio não encontrado."));
    }

    public Estudio criarEstudio(Estudio estudio) {
        return estudioRepository.save(estudio);
    }

    public Estudio atualizarEstudio(Integer id, Estudio atualizado) {
        Estudio existente = getEstudio(id);
        existente.setNomeEstudio(atualizado.getNomeEstudio());
        existente.setDataFundacao(atualizado.getDataFundacao());
        existente.setImagem(atualizado.getImagem());
        return estudioRepository.save(existente);
    }

    public void deletarEstudio(Integer id) {
        Estudio estudio = getEstudio(id);
        estudioRepository.delete(estudio);
    }
}
