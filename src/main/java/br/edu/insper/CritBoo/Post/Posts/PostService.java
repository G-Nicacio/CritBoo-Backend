package br.edu.insper.CritBoo.Post.Posts;

import br.edu.insper.CritBoo.Jogo.Avaliacao.Avaliacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public void salvarPost(Post post) {
        postRepository.save(post);
    }

    public Post getPost(Integer id) {
        return postRepository.findById(id).get();
    }

    public void deletePost(Integer id) {postRepository.deleteById(id);
    }

    public Post editarPost(Post postantigo, Post post) {
        postantigo.setComentario(post.getComentario());
        postantigo.setUsuario(post.getUsuario());

        return postRepository.save(postantigo);
    }
}
