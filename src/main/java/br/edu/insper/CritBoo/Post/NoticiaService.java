package br.edu.insper.CritBoo.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@Service
public class NoticiaService {

    private HashMap<Integer, Noticia> noticias = new HashMap<>();

    public HashMap<Integer, Noticia> getNoticias () {
        return noticias;
    }

    public void salvarNoticia(Noticia noticia){
        noticias.put(noticia.getId(), noticia);
    }

    public Noticia getNoticia(Integer id) {
        return noticias.get(id);
    }

    public Noticia deleteNoticia(Integer id) {
        return noticias.remove(id);
    }

    public Noticia editarNoticia(Integer id, Noticia noticia) {
        Noticia noticiaEditar = getNoticia(id);

        if (noticiaEditar != null) {

            if (noticia.getTitulo() != null) {
                noticiaEditar.setTitulo(noticia.getTitulo());
            }

            if (noticia.getConteudo() != noticiaEditar.getConteudo()) {
                noticiaEditar.setConteudo(noticia.getConteudo());
            }

            if (noticia.getFonte() != noticiaEditar.getFonte()) {
                noticiaEditar.setFonte(noticia.getFonte());
            }
        }
        return noticiaEditar;
    }

}
