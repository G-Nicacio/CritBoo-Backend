package br.edu.insper.CritBoo.Jogo.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria")
    public List<CategoriaJogosDTO> getCategorias(){
        if (categoriaService.getCategorias().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há categorias registradas");
        }

        return categoriaService.getCategorias().stream()
                .map(CategoriaJogosDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/categoria/{id}")
    public CategoriaJogosDTO getCategoria(@PathVariable Integer id){
        return new CategoriaJogosDTO(categoriaService.getCategoria(id));
    }


    @PostMapping("/categoria")
    public Categoria registrarCategoria(@RequestBody Categoria categoria) {
        if (categoria.getNomeCategoria() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser nulo");
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

        return categoriaService.atualizarCategoria(categoriaReturn, categoria);
    }
}
