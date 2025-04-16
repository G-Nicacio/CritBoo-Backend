package br.edu.insper.CritBoo.Jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria")
    public List<Categoria> getCategorias(){
        if (categoriaService.getCategorias().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há categorias registradas");
        }
        return categoriaService.getCategorias();
    }

    @GetMapping("/categoria/{id}")
    public Categoria getCategoria(@PathVariable Integer id){
        return categoriaService.getCategoria(id);
    }

    @PostMapping("/categoria")
    public Categoria registrarCategoria(@RequestBody Categoria categoria) {
        if (categoria.getNomeCategoria() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser nulo");
        }

        if (categoria.getDescricao() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Descrição não pode ser nula");
        }

        categoriaService.registrarCategoria(categoria);
        return categoria;
    }

    @DeleteMapping("/categoria/{id}")
    public Categoria deletarCategoria(@PathVariable Integer id) {
        Categoria categoria = categoriaService.getCategoria(id);
        if (categoria != null) {
            categoriaService.deletarCategoria(id);
            return categoria;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria " + id + " não encontrada");
    }

    @PutMapping("/categoria/{id}")
    public Categoria editarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {

        Categoria categoriaReturn = categoriaService.getCategoria(id);
        if (categoriaReturn == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria "+ id +" não encontrada");
        }
        if (categoria.getNomeCategoria() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser nulo");
        }

        if (categoria.getDescricao() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Descrição não pode ser nula");
        }
        return categoriaService.atualizarCategoria(categoriaReturn, categoria);
    }
}
