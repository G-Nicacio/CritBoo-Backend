package br.edu.insper.CritBoo.Jogo.Avaliacao;

import br.edu.insper.CritBoo.Jogo.Jogos.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
    List<Avaliacao> findByJogo(Jogo jogo);
}
