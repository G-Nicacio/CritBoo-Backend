package br.edu.insper.CritBoo.Jogo;

import br.edu.insper.CritBoo.Usuario.Usuario;

import java.time.LocalDateTime;
import java.util.Random;

public class Avaliacao {
    private Random geraId = new Random();
    private Integer id = geraId.nextInt(1000000);
    private String comentario;
    private LocalDateTime dataAvaliacao;
    private float nota;
    private Usuario usuario = new Usuario();
    private Jogo jogo = new Jogo();

    public String getComentario() {return comentario;}

    public void setComentario(String comentario) {this.comentario = comentario;}

    public LocalDateTime getDataAvaliacao() {return dataAvaliacao;}

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {this.dataAvaliacao = dataAvaliacao;}

    public float getNota() {return nota;}

    public void setNota(float nota) {this.nota = nota;}

    public Usuario getUsuario() {return usuario;}

    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public Jogo getJogo() {return jogo;}

    public void setJogo(Jogo jogo) {this.jogo = jogo;}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}
}