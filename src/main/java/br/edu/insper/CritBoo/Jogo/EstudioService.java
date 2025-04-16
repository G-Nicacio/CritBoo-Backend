package br.edu.insper.CritBoo.Jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

    public List<Estudio> getEstudios() {
        return estudioRepository.findAll();
    }

    public Estudio getEstudioEspecifico(Integer id) {
        return estudioRepository.findById(id).get();
    }

    public void registrarEstudio(Estudio estudioRecebido) {
        estudioRepository.save(estudioRecebido);
    }

    public void removerEstudio(Integer id) {
        estudioRepository.deleteById(id);
    }

    public HashMap<String, Estudio> atualizarEstudio(Estudio estudioAntigo, Estudio novoEstudio) {
        estudioAntigo.setNomeEstudio(novoEstudio.getNomeEstudio());
        estudioAntigo.setJogos(novoEstudio.getJogos());
        estudioAntigo.setDataFundacao(novoEstudio.getDataFundacao());
    }
}
