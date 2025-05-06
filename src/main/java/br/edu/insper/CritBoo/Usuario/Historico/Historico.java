package br.edu.insper.CritBoo.Usuario.Historico;

import br.edu.insper.CritBoo.Jogo.Avaliacao.Avaliacao;
import br.edu.insper.CritBoo.Post.Posts.Post;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private Post post;

    @OneToMany(mappedBy = "historico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    // Getters e setters

    public Integer getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
