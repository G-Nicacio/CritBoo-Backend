package br.edu.insper.CritBoo.Post.Posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarPost(@RequestBody Post post) {
        if (post.getComentario() == null || post.getComentario().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comentario não pode ser nulo");
        }

        if (post.getUsuario() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario não pode ser nulo");
        }

        postService.salvarPost(post);
        return String.format("O ID do post é: %d", post.getId());
    }

    @GetMapping("post/{id}")
    public Post getPost(@PathVariable Integer id) {
        return postService.getPost(id);
    }

    @DeleteMapping("post/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Post excluirPost(@PathVariable Integer id) {
        Post post = postService.getPost(id);
        if (post == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post " + id + " não encontrado");
        }
        postService.deletePost(id);
        return post;
    }

    @PutMapping("post/{id}")
    public Post editarPost(@PathVariable Integer id, @RequestBody Post post) {
        Post postRetorno = postService.getPost(id);

        if (post.getComentario() == null || post.getComentario().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comentario não pode ser nulo");
        }

        if (post.getUsuario() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario não pode ser nulo");
        }

        if (postRetorno != null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post " + id + " não encontrado");
        }
        return postService.editarPost(postRetorno, post);
    }
}
