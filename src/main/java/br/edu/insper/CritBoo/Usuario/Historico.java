package br.edu.insper.CritBoo.Usuario;

import br.edu.insper.CritBoo.Jogo.Avaliacao;
import br.edu.insper.CritBoo.Post.Post;

import java.util.Random;

public class Historico {
    private Post post = new Post();
    private Avaliacao avaliacao = new Avaliacao();
    private Random geraId = new Random();
    private Integer id = geraId.nextInt(1000000);

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
