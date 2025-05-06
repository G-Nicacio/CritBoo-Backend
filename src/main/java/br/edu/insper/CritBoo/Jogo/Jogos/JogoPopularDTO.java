package br.edu.insper.CritBoo.Jogo.Jogos;

public class JogoPopularDTO {
    private Integer id;
    private String nomeJogo;
    private String imagem;

    public JogoPopularDTO(Integer id, String nomeJogo, String imagem) {
        this.id = id;
        this.nomeJogo = nomeJogo;
        this.imagem = imagem;
    }

    public Integer getId() {
        return id;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public String getImagem() {
        return imagem;
    }
}
