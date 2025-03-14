package br.edu.insper.CritBoo.Jogo;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CategoriaService {
    private HashMap<Integer, Categoria> categorias = new HashMap<>();

    public HashMap<Integer, Categoria> getCategorias() {
        return categorias;
    }

    public Categoria getCategoria(Integer id){
        return categorias.get(id);
    }

    public String registrarCategoria(Categoria categoria) {
        if (categoria.getNomeCategoria() != null && categoria.getNomeCategoria() != "" && categoria.getDescricao() != null && categoria.getDescricao() != ""){
            if (categoria.getId() == 0) {
                categoria.setId(categorias.size() + 1);
            }
            categorias.put(categoria.getId(), categoria);
            return "Categoria registrada";
        }
        return null;
    }

    public Categoria deletarCategoria(Integer id){
        return categorias.remove(id);
    }

    public Categoria atualizarCategoria(Integer id, Categoria categoria){
        Categoria categoriaEdit = categorias.get(id);
        if (categoria.getNomeCategoria() != null && categoria.getNomeCategoria() != "" && categoria.getDescricao() != null && categoria.getDescricao() != "" && categoriaEdit != null) {
            categoriaEdit.setNomeCategoria(categoria.getNomeCategoria());
            categoriaEdit.setDescricao(categoria.getDescricao());
        }
        return categoriaEdit;
    }
}
