package br.edu.insper.CritBoo.Usuario.Historico;

import br.edu.insper.CritBoo.Jogo.Jogos.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico, Integer> {
}
