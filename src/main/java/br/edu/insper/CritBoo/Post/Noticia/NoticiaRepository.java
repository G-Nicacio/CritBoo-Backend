package br.edu.insper.CritBoo.Post.Noticia;

import br.edu.insper.CritBoo.Jogo.Jogos.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {
}
