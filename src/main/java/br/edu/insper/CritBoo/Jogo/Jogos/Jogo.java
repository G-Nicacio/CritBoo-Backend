package br.edu.insper.CritBoo.Jogo.Jogos;

import br.edu.insper.CritBoo.Jogo.Avaliacao.Avaliacao;
import br.edu.insper.CritBoo.Jogo.Categoria.Categoria;
import br.edu.insper.CritBoo.Jogo.Estudio.Estudio;
import br.edu.insper.CritBoo.Post.Noticia.Noticia;
import br.edu.insper.CritBoo.Post.Posts.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nomeJogo;

    @Column(nullable = false)
    private String descricaoJogo;

    @Column(nullable = false)
    private LocalDate lancamentoJogo;

    @ManyToOne
    @JoinColumn(name = "estudio_id", nullable = false)
    @JsonIgnore
    private Estudio estudio;

    @ManyToMany
    @JoinTable(
            name = "jogo_categoria",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @JsonIgnore
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "jogo")
    @JsonIgnore
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @Column(nullable = false)
    private String imagem;

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Post> posts;

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Noticia> noticias;

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNomeJogo() {return nomeJogo;}

    public void setNomeJogo(String nomeJogo) {this.nomeJogo = nomeJogo;}

    public String getDescricaoJogo() {return descricaoJogo;}

    public void setDescricaoJogo(String descricaoJogo) {this.descricaoJogo = descricaoJogo;}

    public LocalDate getLancamentoJogo() {return lancamentoJogo;}

    public void setLancamentoJogo(LocalDate lancamentoJogo) {this.lancamentoJogo = lancamentoJogo;}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public List<Avaliacao> getComentarios() {
        return avaliacoes;
    }

    public void adicionarComentario(Avaliacao comentario) {
        this.avaliacoes.add(comentario);
        comentario.setJogo(this);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }
}
