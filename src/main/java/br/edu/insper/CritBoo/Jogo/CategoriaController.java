package br.edu.insper.CritBoo.Jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria")
    public HashMap<Integer, Categoria> getCategorias(){
        return categoriaService.getCategorias();
    }

    @GetMapping("/categoria/{id}")
    public Categoria getCategoria(@PathVariable Integer id){
        return categoriaService.getCategoria(id);
    }

    @PostMapping("/categoria")
    public String registrarCategoria(@RequestBody Categoria categoria) {
        if (categoriaService.registrarCategoria(categoria) != null) {
            return categoriaService.registrarCategoria(categoria);
        }
        return "Está faltando algum valor";
    }

    @DeleteMapping("/categoria/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletarCategoria(@PathVariable Integer id) {
        Categoria categoria = categoriaService.deletarCategoria(id);
        if (categoria != null) {
            return "Categoria removido com sucesso";
        }
        return "Categoria não encontrada";
    }

    @PutMapping("/categoria/{id}")
    public String editarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {

        Categoria categoriaReturn = categoriaService.atualizarCategoria(id, categoria);
        if (categoriaReturn != null) {
            return "Categoria alterada com sucesso";
        }
        return "Categoria não encontrada";
    }
}
