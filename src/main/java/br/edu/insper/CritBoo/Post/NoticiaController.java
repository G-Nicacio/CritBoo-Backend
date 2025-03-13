package br.edu.insper.CritBoo.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class NoticiaController {
    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/noticia")
    public HashMap<Integer, Noticia> getNoticias() {
        return noticiaService.getNoticias();
    }

    @PostMapping("/noticia")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarNoticia(@RequestBody Noticia noticia) {
        if (noticia.getTitulo() == null) {
            return "Titulo não pode ser nulo";
        }

        if (noticia.getConteudo() == null) {
            return "Conteudo não pode ser nulo";
        }

        if (noticia.getDataNoticia() == null) {
            return "Data não pode ser nulo";
        }

        if (noticia.getFonte() == null) {
            return "Fonte não pode ser nulo";
        }

        noticiaService.salvarNoticia(noticia);
        long id = noticia.getId();
        return String.format("O id da noticia é: %s", id);
    }

    @GetMapping("/noticia/{id}")
    public Noticia getNoticia(@PathVariable Integer id) {
        return noticiaService.getNoticia(id);
    }

    @DeleteMapping("/noticia/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirNoticia(@PathVariable Integer id) {
        Noticia noticia = noticiaService.deleteNoticia(id);
        if (noticia != null) {
            return "Noticia removida com sucesso";
        }
        return "Noticia não encontrada";
    }

    @PutMapping("/noticia/{id}")
    public String editarNoticia(@PathVariable Integer id, @RequestBody Noticia noticia) {

        Noticia noticiaretorno = noticiaService.editarNoticia(id, noticia);
        if (noticiaretorno != null) {
            return "Noticia alterada com sucesso";
        }
        return "Noticia não encontrada";
    }
}
