package br.edu.insper.CritBoo.Jogo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.util.Random;

@Entity
public class Categoria {

    @Column(nullable = false)
    private String nomeCategoria;

    @Column(nullable = false)
    private String descricao;

    @Transient
    private Random geraId = new Random();

    @Id
    private Integer id = geraId.nextInt(1000000);

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {this.id = id;}
}
