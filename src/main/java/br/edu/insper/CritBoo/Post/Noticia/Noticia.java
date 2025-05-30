package br.edu.insper.CritBoo.Post.Noticia;

import br.edu.insper.CritBoo.Jogo.Jogos.Jogo;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String conteudo;

    private LocalDateTime dataNoticia;

    @Column(nullable = false)
    private String fonte;

    @ManyToOne
    @JoinColumn(name = "id_jogo", nullable = false)
    private Jogo jogo;

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataNoticia() {
        return dataNoticia;
    }

    public void setDataNoticia(LocalDateTime dataNoticia) {
        this.dataNoticia = dataNoticia;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}
