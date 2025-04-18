package br.edu.insper.CritBoo.Post.Posts;

import br.edu.insper.CritBoo.Usuario.Usuarios.Usuario;
import jakarta.persistence.*;

//import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Random;

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String comentario;

    private LocalDateTime data;

    @ManyToOne()
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = LocalDateTime.now();
    }
}
