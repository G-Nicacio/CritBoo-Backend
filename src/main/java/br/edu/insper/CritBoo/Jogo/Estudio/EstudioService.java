package br.edu.insper.CritBoo.Jogo.Estudio;

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

    public HashMap<String, Estudio> atualizarEstudio(Estudio estudioAntigo) {
        HashMap<String, Estudio> alteracoes = new HashMap<>();

        Estudio copiaAntes = new Estudio();
        copiaAntes.setNomeEstudio(estudioAntigo.getNomeEstudio());
        copiaAntes.setJogos(estudioAntigo.getJogos());
        copiaAntes.setDataFundacao(estudioAntigo.getDataFundacao());
        copiaAntes.setImagem(estudioAntigo.getImagem()); // Adiciona imagem também

        estudioRepository.save(estudioAntigo);

        alteracoes.put("antes", copiaAntes);
        alteracoes.put("depois", estudioAntigo);

        return alteracoes;
    }

}