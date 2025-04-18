package br.edu.insper.CritBoo.Usuario.Historico;

import br.edu.insper.CritBoo.Jogo.Avaliacao.Avaliacao;
import br.edu.insper.CritBoo.Post.Posts.Post;
import br.edu.insper.CritBoo.Usuario.Usuarios.Usuario;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Post post = new Post();

    @OneToMany
    private Avaliacao avaliacao = new Avaliacao();

    @OneToMany(mappedBy = "usuario")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Integer getId() {
        return id;
    }

}
