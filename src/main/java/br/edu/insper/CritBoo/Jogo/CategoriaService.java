package br.edu.insper.CritBoo.Jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoria(Integer id){
        return categoriaRepository.findById(id).get();
    }

    public void registrarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Integer id){
        categoriaRepository.deleteById(id);
    }

    public Categoria atualizarCategoria(Categoria categoriaAnterior, Categoria categoria){
        categoriaAnterior.setNomeCategoria(categoria.getNomeCategoria());
        categoriaAnterior.setDescricao(categoria.getDescricao());

        return categoriaRepository.save(categoriaAnterior);
    }
}
