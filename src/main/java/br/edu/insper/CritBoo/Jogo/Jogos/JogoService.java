package br.edu.insper.CritBoo.Jogo.Jogos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public Page<Jogo> getJogos(String nome, LocalDate lancamentoJogo, Pageable pageable) {
        if (nome != null && lancamentoJogo != null) {
            return jogoRepository.findByNomeJogoContainingAndLancamentoJogo(nome, lancamentoJogo, pageable);
        } else if (nome != null) {
            return jogoRepository.findByNomeJogoContaining(nome, pageable);
        } else if (lancamentoJogo != null) {
            return jogoRepository.findByLancamentoJogo(lancamentoJogo, pageable);
        }
        return jogoRepository.findAll(pageable);
    }

    public Jogo getJogos(Integer id) {
        return jogoRepository.findById(id).orElse(null);
    }

    public void salvarJogo(Jogo jogo){
        jogoRepository.save(jogo);
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
            if (jogo.getImagem() != null) {
                jogoEditar.setImagem(jogo.getImagem());
            }
            return jogoRepository.save(jogoEditar);
        }
        return null;
    }

    public Page<Jogo> getTopJogos(int quantidade) {
        Pageable pageable = PageRequest.of(0, quantidade);
        return jogoRepository.findJogosRecentes(pageable);
    }
}
