package br.edu.insper.CritBoo.Post.Posts;

import br.edu.insper.CritBoo.Jogo.Jogos.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
