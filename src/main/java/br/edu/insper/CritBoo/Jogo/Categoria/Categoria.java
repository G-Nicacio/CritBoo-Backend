package br.edu.insper.CritBoo.Jogo.Categoria;

import br.edu.insper.CritBoo.Jogo.Jogos.Jogo;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nomeCategoria;

    @ManyToMany(mappedBy = "categorias")
    private Set<Jogo> jogos = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {this.id = id;}

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Set<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(Set<Jogo> jogos) {
        this.jogos = jogos;
    }
}
