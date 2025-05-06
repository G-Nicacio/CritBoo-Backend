package br.edu.insper.CritBoo.Jogo.Jogos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.Query;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {

    Page<Jogo> findByNomeJogoContainingAndLancamentoJogo(String nome, LocalDate lancamentoJogo, Pageable pageable);

    Page<Jogo> findByNomeJogoContaining(String nome, Pageable pageable);

    Page<Jogo> findByLancamentoJogo(LocalDate lancamentoJogo, Pageable pageable);

    @Query("SELECT j FROM Jogo j ORDER BY j.lancamentoJogo DESC")
    Page<Jogo> findJogosRecentes(Pageable pageable);
}
