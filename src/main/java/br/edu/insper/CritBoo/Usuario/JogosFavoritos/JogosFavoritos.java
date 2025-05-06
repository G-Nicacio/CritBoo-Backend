package br.edu.insper.CritBoo.Usuario.JogosFavoritos;

import br.edu.insper.CritBoo.Jogo.Jogos.Jogo;
import br.edu.insper.CritBoo.Usuario.Usuarios.Usuario;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class JogosFavoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "jogos_favoritos_jogo",
            joinColumns = @JoinColumn(name = "jogos_favoritos_id"),
            inverseJoinColumns = @JoinColumn(name = "jogo_id")
    )
    private Set<Jogo> jogosFavoritos = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Jogo> getJogosFavoritos() {
        return jogosFavoritos;
    }

    public void setJogosFavoritos(Set<Jogo> jogosFavoritos) {
        this.jogosFavoritos = jogosFavoritos;
    }

}
