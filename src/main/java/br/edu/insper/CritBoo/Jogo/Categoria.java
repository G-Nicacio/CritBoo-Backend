package br.edu.insper.CritBoo.Jogo;

import java.util.Random;

public class Categoria {
    private String nomeCategoria;
    private String descricao;
    private Random geraId = new Random();
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
