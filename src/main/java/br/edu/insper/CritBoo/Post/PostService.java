package br.edu.insper.CritBoo.Post;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PostService {
    private HashMap<Integer, Post> posts = new HashMap<>();

    public HashMap<Integer, Post> getPosts() {
        return posts;
    }

    public void salvarPost(Post post) {
        posts.put(post.getId(), post);
    }

    public Post getPost(Integer id) {
        return posts.get(id);
    }

    public Post deletePost(Integer id) {
        return posts.remove(id);
    }

    public Post editarPost(Integer id, Post post) {
        Post postEditar = getPost(id);

        if (postEditar != null) {
            if (post.getComentario() != null) {
                postEditar.setComentario(post.getComentario());
            }

            if (post.getUsuario() != null) {
                postEditar.setUsuario(post.getUsuario());
            }
        }
        return postEditar;
    }
}
