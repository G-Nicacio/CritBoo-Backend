package br.edu.insper.CritBoo.Jogo.Categoria;

public class CategoriaDTO {
    private Integer id;
    private String nomeCategoria;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nomeCategoria = categoria.getNomeCategoria();
    }

    public Integer getId() {
        return id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }
}
