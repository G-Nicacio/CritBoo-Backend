package br.edu.insper.CritBoo.Jogo.Categoria;

import br.edu.insper.CritBoo.Jogo.Jogos.Jogo;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaJogosDTO {
    private Integer id;
    private String nomeCategoria;
    private List<Integer> jogos;

    public CategoriaJogosDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nomeCategoria = categoria.getNomeCategoria();
        this.jogos = categoria.getJogos().stream()
                .map(Jogo::getId)
                .collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public List<Integer> getJogos() {
        return jogos;
    }
}

