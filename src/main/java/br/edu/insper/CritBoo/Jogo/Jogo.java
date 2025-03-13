package br.edu.insper.CritBoo.Jogo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    private Random geraId = new Random();
    private Integer id = geraId.nextInt(1000000);
    private String nomeJogo;
    private String descricaoJogo;
    private LocalDate lancamentoJogo;
    private ArrayList<Categoria> categorias = new ArrayList<>();
    private Avaliacao comentarios;
    private Estudio estudio = new Estudio();

    public String getNomeJogo() {return nomeJogo;}

    public void setNomeJogo(String nomeJogo) {this.nomeJogo = nomeJogo;}

    public String getDescricaoJogo() {return descricaoJogo;}

    public void setDescricaoJogo(String descricaoJogo) {this.descricaoJogo = descricaoJogo;}

    public LocalDate getLancamentoJogo() {return lancamentoJogo;}

    public void setLancamentoJogo(LocalDate lancamentoJogo) {this.lancamentoJogo = lancamentoJogo;}

    public ArrayList<Categoria> getCategorias() {return categorias;}

    public void setCategorias(ArrayList<Categoria> categorias) {this.categorias = categorias;}

    public Avaliacao getComentarios() {return comentarios;}

    public void setComentarios(Avaliacao comentarios) {this.comentarios = comentarios;}

//    public Estudio getEstudio() {return estudio;}
//
//    public void setEstudio(Estudio estudio) {this.estudio = estudio;}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}
}
