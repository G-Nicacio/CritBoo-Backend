package br.edu.insper.CritBoo.Jogo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Estudio {
    private String nomeEstudio;
    private ArrayList<Jogo> jogos = new ArrayList<>();
    private LocalDate dataFundacao;

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
