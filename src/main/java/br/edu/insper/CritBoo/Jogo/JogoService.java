package br.edu.insper.CritBoo.Jogo;

import br.edu.insper.CritBoo.Usuario.Usuario;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class JogoService {

    private HashMap<Integer, Jogo> jogos = new HashMap<>();

    public HashMap<Integer, Jogo> getJogos() {
        return jogos;
    }

    public void salvarJogo(Jogo jogo){
        if (jogo.getId() == 0) {
            jogo.setId(jogos.size() + 1);
        }
        jogos.put(jogo.getId(),jogo);
    }

    public Jogo getJogos(Integer id) {
        return jogos.get(id);
    }

    public Jogo deleteJogo(Integer id) {
        return (jogos.remove(id));
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
//            if (jogo.getEstudio() != null) {
//                jogoEditar.setEstudio(jogo.getEstudio());
//            }
        }
        return jogoEditar;
    }


}
