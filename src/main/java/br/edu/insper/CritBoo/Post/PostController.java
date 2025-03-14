package br.edu.insper.CritBoo.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public HashMap<Integer, Post> getPosts() {
        return postService.getPosts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarPost(@RequestBody Post post) {
        if (post.getComentario() == null || post.getComentario().isEmpty()) {
            return "Comentário não pode ser nulo";
        }

        if (post.getUsuario() == null) {
            return "Usuário não pode ser nulo";
        }

        postService.salvarPost(post);
        return String.format("O ID do post é: %d", post.getId());
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Integer id) {
        return postService.getPost(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirPost(@PathVariable Integer id) {
        Post post = postService.deletePost(id);
        if (post != null) {
            return "Post removido com sucesso";
        }
        return "Post não encontrado";
    }

    @PutMapping("/{id}")
    public String editarPost(@PathVariable Integer id, @RequestBody Post post) {
        Post postRetorno = postService.editarPost(id, post);
        if (postRetorno != null) {
            return "Post alterado com sucesso";
        }
        return "Post não encontrado";
    }
}
