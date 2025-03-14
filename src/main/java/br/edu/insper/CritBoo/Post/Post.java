package br.edu.insper.CritBoo.Post;

import br.edu.insper.CritBoo.Usuario.Usuario;

import javax.persistence.*;
import java.util.Random;

@Entity
public class Post {
    private Random geraId = new Random();
    private Integer id = geraId.nextInt(1000000);
    private String comentario;

    @ManyToOne
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
}
