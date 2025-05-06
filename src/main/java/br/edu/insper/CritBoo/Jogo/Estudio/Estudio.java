package br.edu.insper.CritBoo.Jogo.Estudio;

import br.edu.insper.CritBoo.Jogo.Jogos.Jogo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
public class Estudio {
    @Column(nullable = false)
    private String nomeEstudio;

    @ManyToMany
    @JoinTable(
            name = "estudio",
            joinColumns = @JoinColumn(name = "estudio_id"),
            inverseJoinColumns = @JoinColumn(name = "jogo_id")
    )
    private ArrayList<Jogo> jogos = new ArrayList<>();

    @Column(nullable = false)
    private LocalDate dataFundacao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String imagem;

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNomeEstudio() {
        return nomeEstudio;
    }
    public void setNomeEstudio(String nomeEstudio) {
        this.nomeEstudio = nomeEstudio;
    }

    public ArrayList<Jogo> getJogos() {
        return jogos;
    }
    public void setJogos(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
