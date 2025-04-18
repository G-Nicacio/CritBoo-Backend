package br.edu.insper.CritBoo.Jogo.Jogos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> getJogos() {
        return jogoRepository.findAll();
    }

    public void salvarJogo(Jogo jogo){
        jogoRepository.save(jogo);
    }

    public Jogo getJogos(Integer id) {
        return jogoRepository.findById(id).get();
    }

    public void deleteJogo(Integer id) {
        jogoRepository.deleteById(id);
    }

    public Jogo editarJogo(Integer id, Jogo jogo) {
        Jogo jogoEditar = getJogos(id);

        if (jogoEditar != null) {

            if (jogo.getNomeJogo() != null) {
                jogoEditar.setNomeJogo(jogo.getNomeJogo());
            }
            if (jogo.getDescricaoJogo() != null) {
                jogoEditar.setDescricaoJogo(jogo.getDescricaoJogo());
            }
            if (jogo.getLancamentoJogo() != null) {
                jogoEditar.setLancamentoJogo(jogo.getLancamentoJogo());
            }

        }
        return jogoEditar;
    }


}
