package br.edu.insper.CritBoo.Jogo;

import br.edu.insper.CritBoo.Usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Entity
public class Avaliacao {
    @Transient
    private Random geraId = new Random();
    @Id
    private Integer id = geraId.nextInt(1000000);

    @Column(nullable = false)
    private String comentario;

    private LocalDateTime dataAvaliacao;

    @Column(nullable = false)
    private Float nota;

    @ManyToOne()
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_jogo")
    private Jogo jogo;

    public String getComentario() {return comentario;}

    public void setComentario(String comentario) {this.comentario = comentario;}

    public LocalDateTime getDataAvaliacao() {return dataAvaliacao;}

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {this.dataAvaliacao = dataAvaliacao;}

    public Float getNota() {return nota;}

    public void setNota(float nota) {this.nota = nota;}

    public Usuario getUsuario() {return usuario;}

    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public Jogo getJogo() {return jogo;}

    public void setJogo(Jogo jogo) {this.jogo = jogo;}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}
}