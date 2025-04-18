package br.edu.insper.CritBoo.Post.Noticia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@RestController
public class NoticiaController {
    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/noticia")
    public List<Noticia> getNoticias() {
        return noticiaService.getNoticia();
    }

    @PostMapping("/noticia")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarNoticia(@RequestBody Noticia noticia) {
        if (noticia.getTitulo() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Título não pode ser nulo");
        }

        if (noticia.getConteudo() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conteudo não pode ser nulo");
        }

        if (noticia.getDataNoticia() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data não pode ser nulo");
        }

        if (noticia.getFonte() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fonte não pode ser nulo");
        }

        noticiaService.salvarNoticia(noticia);
        int id = noticia.getId();
        return String.format("O id da noticia é: %s", id);
    }

    @GetMapping("/noticia/{id}")
    public Noticia getNoticia(@PathVariable Integer id) {
        return noticiaService.getNoticia(id);
    }

    @DeleteMapping("/noticia/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Noticia excluirNoticia(@PathVariable Integer id) {
        Noticia noticia = noticiaService.getNoticia(id);
        if (noticia == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Noticia " + id + " não encontrado");
        }
        return noticia;
    }

    @PutMapping("/noticia/{id}")
    public Noticia editarNoticia(@PathVariable Integer id, @RequestBody Noticia noticia) {

        Noticia noticiaretorno = noticiaService.getNoticia(id);

        if (noticia.getTitulo() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Título não pode ser nulo");
        }

        if (noticia.getConteudo() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conteudo não pode ser nulo");
        }

        if (noticia.getFonte() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fonte não pode ser nulo");
        }

        if (noticiaretorno == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Noticia " + id + " não encontrado");
        }
        return noticiaService.editarNoticia(noticiaretorno, noticia);
    }
}
