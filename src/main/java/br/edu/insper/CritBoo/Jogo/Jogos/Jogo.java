package br.edu.insper.CritBoo.Jogo.Jogos;

import br.edu.insper.CritBoo.Jogo.Avaliacao.Avaliacao;
import br.edu.insper.CritBoo.Jogo.Categoria.Categoria;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nomeJogo;

    @Column(nullable = false)
    private String descricaoJogo;

    @Column(nullable = false)
    private LocalDate lancamentoJogo;

    @ManyToMany
    @JoinTable(
            name = "jogo",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")

    )
    private List<Categoria> categorias = new ArrayList<>();

    @OneToMany(mappedBy = "jogo")
    private List<Avaliacao> comentarios = new ArrayList<>();

//    private Estudio estudio = new Estudio();

    @Column(nullable = false)
    private String imagem;

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNomeJogo() {return nomeJogo;}

    public void setNomeJogo(String nomeJogo) {this.nomeJogo = nomeJogo;}

    public String getDescricaoJogo() {return descricaoJogo;}

    public void setDescricaoJogo(String descricaoJogo) {this.descricaoJogo = descricaoJogo;}

    public LocalDate getLancamentoJogo() {return lancamentoJogo;}

    public void setLancamentoJogo(LocalDate lancamentoJogo) {this.lancamentoJogo = lancamentoJogo;}

    public List<Categoria> getCategorias() {return categorias;}

    public void setCategorias(ArrayList<Categoria> categorias) {this.categorias = categorias;}

//    public Avaliacao getComentarios() {return comentarios;}
//
//    public void setComentarios(Avaliacao comentarios) {this.comentarios = comentarios;}

//    public Estudio getEstudio() {return estudio;}
//
//    public void setEstudio(Estudio estudio) {this.estudio = estudio;}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}
}
