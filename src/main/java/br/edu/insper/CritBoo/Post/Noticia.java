package br.edu.insper.CritBoo.Post;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;
import java.util.Random;

public class Noticia {
    private Random geraId = new Random();
    private String titulo;
    private String conteudo;
    private LocalDateTime dataNoticia;
    private String fonte;
    private long id = geraId.nextInt(1000000);

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

    public long getId() {
        return id;
    }

}
