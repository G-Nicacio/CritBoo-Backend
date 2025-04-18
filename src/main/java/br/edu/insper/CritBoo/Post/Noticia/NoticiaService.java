package br.edu.insper.CritBoo.Post.Noticia;

import br.edu.insper.CritBoo.Post.Posts.Post;
import br.edu.insper.CritBoo.Post.Posts.PostRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    public List<Noticia> getNoticia() {
        return noticiaRepository.findAll();
    }

    public void salvarNoticia(Noticia noticia){
        noticiaRepository.save(noticia);
    }

    public Noticia getNoticia(Integer id) {
        return noticiaRepository.findById(id).get();
    }

    public void deleteNoticia(Integer id) {
        noticiaRepository.deleteById(id);
    }

    public Noticia editarNoticia(Noticia noticiaAntiga, Noticia noticia) {
        noticiaAntiga.setConteudo(noticia.getConteudo());
        noticiaAntiga.setFonte(noticia.getFonte());
        noticiaAntiga.setTitulo(noticia.getTitulo());

        return noticiaRepository.save(noticiaAntiga);
    }

}
